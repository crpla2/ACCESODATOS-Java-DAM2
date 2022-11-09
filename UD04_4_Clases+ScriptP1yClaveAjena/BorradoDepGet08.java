import org.hibernate.ObjectNotFoundException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.exception.ConstraintViolationException;

import primero.Departamentos;
import primero.SessionFactoryUtil;

public class BorradoDepGet08 {

	public static void main(String[] args) {
		SessionFactory sesion = SessionFactoryUtil.getSessionFactory();
		Session session = sesion.openSession();
		Transaction tx = session.beginTransaction();

		Departamentos de = (Departamentos) 
				session.get(Departamentos.class, (byte) 23);

		if (de==null) {			
			System.out.println("El departamento no existe");
		}
		else
		{
			try {
				session.delete(de); // elimina el objeto
				tx.commit();
				System.out.println("Departamento eliminado");
			} catch (ObjectNotFoundException o) {
				System.out.println("NO EXISTE EL DEPARTAMENTO...");
			} catch (ConstraintViolationException c) {
				System.out.println("NO SE PUEDE ELIMINAR, TIENE EMPLEADOS...");
			}catch (Exception e) {
				System.out.println("ERROR NO CONTROLADO....");
				e.printStackTrace();
			}
		}
		
		session.close();
		System.exit(0);

	}

}
