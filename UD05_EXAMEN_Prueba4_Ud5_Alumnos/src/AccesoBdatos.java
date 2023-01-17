
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

//

public class AccesoBdatos {
	private EntityManagerFactory emf;
	private EntityManager em;

	public void conectar() {
		emf = Persistence.createEntityManagerFactory("db/gestionStock.odb");
		em = emf.createEntityManager();
	}

	public void desconectar() {
		em.close();
		emf.close();
		System.exit(0);
	}

	public boolean pregunta1(int codigo, String telefono) {
		Tienda t = em.find(Tienda.class, codigo);
		if (t == null)
			return false;
		else {
			Query query = em.createQuery("UPDATE Tienda t SET t.tlf=:telefono WHERE t.cod=:codigo");
			query.setParameter("telefono", telefono);
			query.setParameter("codigo", codigo);
			try {
				em.getTransaction().begin();
				query.executeUpdate();
				em.getTransaction().commit();
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}

	public long pregunta2() {
		TypedQuery<Familia> tq = em.createQuery("SELECT f FROM Familia f", Familia.class);
		List<Familia> li = tq.getResultList();
		return li.size();
	}

	public void pregunta3(String codigoP, int codigoT) {
		int totalStock;
		try {
			totalStock = (int) em.createQuery("SELECT s.unidades FROM Stock s WHERE s.tienda=:T and s.producto.getCod()=:P ")
					.setParameter("T", codigoT)
					.setParameter("P", codigoP)
					.getSingleResult();
		} catch (Exception e) {
			totalStock = 0;
		}
					
		System.out.println(
				"Total de unidades del producto " + codigoP + " en la tienda " + codigoT + " --> " + totalStock+"\n");
	}

	public void pregunta4() {
		@SuppressWarnings("unchecked")
		List<String> productosID = em.createQuery(
				"SELECT distinct s.producto FROM Stock s" )
				.getResultList();
		System.out.println("Productos distintos: "+productosID.size());
		System.out.println();
		
		TypedQuery<Object[]> tq=em.createQuery("select  s.producto.getNombreCorto() , count(s.tienda), sum(s.unidades) from Stock s group by s.producto.getNombreCorto() order by s.producto.getNombreCorto() ",Object[].class);
		List<Object[]>listap=tq.getResultList();
		for(Object[] o:listap) {
				
		System.out.println("Producto: "+o[0]+", disponible en "+o[1]+" tienda(s), total Unidades "+o[2]);
		}
		System.out.println();
	}

	public void pregunta5() {
		TypedQuery<Producto> tQuery = em.createQuery("select e from Producto e",
				Producto.class);
		List<Producto> listaProductos = tQuery.getResultList();
		System.out.println("Producto (nombre corto) - \tPrecio -\tFamilia\n=======================================================");
		for(Producto p:listaProductos) {
			if(p.getStocks().size()==0) {
				System.out.println(p.getNombreCorto()+" - "+p.getPvp()+" - "+p.getFamilia().getNombre());
			}
		}
	}
}
