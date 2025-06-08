# Conversor de Monedas en Java

Aplicación de consola en Java que permite convertir entre diferentes monedas utilizando tasas de cambio obtenidas de una API externa.

---

## Descripción

Este proyecto implementa un conversor de monedas que conecta con una API pública para obtener las tasas de cambio actuales y realiza conversiones entre:

- Dólar estadounidense (USD)
- Peso argentino (ARS)
- Real brasileño (BRL)
- Euro europa  (EUR)
- Peso mexicano (MXN)
  

El programa ofrece un menú interactivo en consola para que el usuario pueda seleccionar el tipo de conversión y el monto a convertir.

---

## Tecnologías usadas

- Java 11+
- HttpClient (Java 11) para hacer solicitudes HTTP
- Gson para el procesamiento de JSON
- API pública de tasas de cambio (configurada en `ApiCliente`)

---

## Funcionalidades

- Solicita al usuario la opción de conversión
- Obtiene tasas de cambio en tiempo real desde la API
- Convierte el monto ingresado según la tasa correspondiente
- Registro con marca de tiempo (usando java.time.LocalDateTime)
- Maneja opciones inválidas y permite salir con opción 9
  

---


## Estructura del proyecto

- `Conversor.java`: Clase principal con la interfaz de usuario y lógica básica.
- `ApiCliente.java`: Clase encargada de hacer la conexión HTTP con la API.
- `TasaCambio.java`: Clase modelo para mapear los datos JSON recibidos.
- `libs/gson.jar`: Biblioteca Gson 

## Autor
Ariel Caferri
