# calculadora
Pasos para generar el archivo Jar desde Intellij (IDEA donde he desarrollado este proyecto): 

  1. Tenemos que ir a 'File' -> 'Project Structure'. 
  2. Se abrirá una nueva ventana, nos vamos a la pestaña 'Artifacts' y damos al botón '+'. 
  3. Se abrirá una nueva ventana, en ella debemos seleccionar la clase main de nuestro proyecto. 
  4. Aceptamos y aplicamos todos los cambios, para cerrar todas estas pestañas. 
  5. Ahora vamos a la pestaña de 'Build' -> 'Build Artifacts...'. 
  6. Se nos despliegan una serie de opciones y seleccionamos 'Build'. 
  7. Se nos creara una carpeta nueva llamada 'out', en ella podemos encontrar nuestro archivo Jar. 


Pasos para ejecutar el archivo Jar generado desde Intellij: 

  1. En la carpeta nueva llamada 'out', hacemos click derecho sobre el archivo Jar, que se acaba de generar. 
  2. Seleccionamos 'Open In' -> 'Explorer'. 
  3. Se nos abre la ubicación del archivo, hacemos click derecho en esta ubicación y seleccionamos 'Abrir en Terminal'. 
  4. En la consola escribimos 'java -jar' y el nombre del archivo y ya se estaría ejecutando nuestro proyecto. 
