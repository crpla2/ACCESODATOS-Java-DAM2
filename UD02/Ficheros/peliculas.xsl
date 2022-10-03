<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
   <xsl:template match="/">
      <html>
         <body>
            <h1>Peliculas</h1>
            <table border="1">
               <tr>
                  <th>Id</th>
                  <th>Titulo</th>
                  <th>Año</th>
                  <th>Descripción</th>
               </tr>
               <xsl:for-each select="peliculas/pelicula">
                  <tr>
                     <td>
                        <xsl:value-of select="id" />
                     </td>
                     <td>
                        <xsl:value-of select="titulo" />
                     </td>
                     <td>
                        <xsl:value-of select="año" />
                     </td>
                     <td>
                        <xsl:value-of select="descripcion" />
                     </td>
                  </tr>
               </xsl:for-each>
            </table>
         </body>
      </html>
   </xsl:template>
</xsl:stylesheet>