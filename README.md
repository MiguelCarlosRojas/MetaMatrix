# AS221S5_T07

# 📘 Guía Completa de IBM Watson Natural Language Understanding (NLU) Service Management

## 💻 Autores:
👨🏻‍💻 Toshiro Inami    
👨🏻‍💻 Jhanmarco Godoy   
👨🏻‍💻 Miguel Rojas


## 🚀 Introducción
![Watson_master_stems_20180315+(1-01-19-10)](https://github.com/vallegrande/AS221S5_T07_be/assets/111800631/773e1863-27fe-4804-aaf2-211083f869bf)
Este repositorio proporciona una guía detallada sobre cómo utilizar ```IBM Watson Natural Language Understanding``` en IBM Cloud para analizar texto, extraer información útil, realizar tareas avanzadas y maximizar su potencial.

## ℹ️ Acerca de IBM Watson Natural Language Understanding
```IBM Watson Natural Language Understanding``` es un servicio de inteligencia artificial (IA) que permite analizar texto para extraer metadatos de contenido como conceptos, entidades, emociones, relaciones, sentimientos y más.
![Captura de pantalla 2024-05-02 161223](https://github.com/vallegrande/AS221S5_T07_be/assets/111800631/1f2eb54b-0ac7-4f3d-aabe-2a64b6c9bd1e)

## ℹ️ Información del Servicio
Aquí encontrarás información adicional sobre el servicio de ```IBM Watson Natural Language Understanding```:
![Captura de pantalla 2024-05-02 161648](https://github.com/vallegrande/AS221S5_T07_be/assets/111800631/c33c0d87-0ab6-4ecc-bc29-3b6359f51d6e)

### 🔍 Categoría y Conformidad
- **Categoría:** IA / Aprendizaje automático
- **Conformidad:**
  - Soporte en la UE
  - Habilitado para HIPAA
  - Habilitado para IAM

### 🌍 Ubicaciones Disponibles
El servicio está disponible en varias ubicaciones, incluyendo:
- Sídney
- Frankfurt
- Londres
- Dallas
- Tokio
- Washington D. C.

### 💳 Planes de Precios
Existen varios planes de precios, incluyendo:

- #### 🆓 Lite
  - 30,000 elementos de NLU al mes
  - 1 modelo personalizado
  - [Más información](https://cloud.ibm.com/catalog/services/natural-language-understanding)

- #### 🔄 Estándar
  - Número ilimitado de elementos de NLU por mes
  - Se le facturará por elemento de NLU y por modelo personalizado
  - [Más información](https://cloud.ibm.com/catalog/services/natural-language-understanding)

- #### 🎯 Multicapa
  - [Más información](https://cloud.ibm.com/catalog/services/natural-language-understanding)

## 🛠️ Guía de Configuración
Para comenzar a utilizar ```IBM Watson Natural Language Understanding```, sigue estos pasos:

- ### 1️⃣ Paso 1: Iniciar Sesión en IBM Cloud
  Accede a tu cuenta en ```IBM Cloud```.

- ### 2️⃣ Paso 2: Acceder al Catálogo
  Navega al catálogo de servicios desde el menú de navegación.

- ### 3️⃣ Paso 3: Seleccionar y Configurar el Servicio
  Busca "```Natural Language Understanding```" y selecciona el servicio. Luego, crea una instancia con estos detalles:
    - **Nombre de la Instancia:** Especifique un nombre descriptivo.
    - **Grupo de Recursos:** Seleccione un grupo existente o cree uno nuevo.
    - **Añadir Etiquetas:** Opcionalmente, organice sus recursos con etiquetas.
    - **Coste Total:** Elija el plan que mejor se adapte a sus necesidades.

- ### 4️⃣ Paso 4: Obtener Credenciales
  Una vez creada la instancia, obtén las ```credenciales``` necesarias para acceder al servicio.

- ### 5️⃣ Paso 5: Verificación del Funcionamiento
  Asegúrese de que la instancia esté en funcionamiento y obtenga la URL de la ```API```.

## 🔑 Credenciales de Acceso
A continuación se muestran las ```credenciales``` necesarias para acceder al servicio:
![Captura de pantalla 2024-05-02 160401](https://github.com/vallegrande/AS221S5_T07_be/assets/111800631/77d3afe3-cac4-487a-9224-5dc921d8ca02)

- **Clave de API:**
```bash
YJaDwuQIFcWqE9eDM3sV_wvV7SoF7efcZZrcCvyYFLe5
```

- **URL:**
```bash
https://api.us-east.natural-language-understanding.watson.cloud.ibm.com/instances/c36e7ec0-b19c-4f02-ab6a-fab0a132757f
```

## 🚀 Solicitud de Ejemplo con cURL
A continuación se proporciona un ejemplo de cómo utilizar ```IBM Watson Natural Language Understanding``` con cURL:
![Captura de pantalla 2024-05-02 161020](https://github.com/vallegrande/AS221S5_T07_be/assets/111800631/34e53519-2bdc-47df-a9af-55a2e07b589c)

```bash
curl -X POST -u "apikey:YJaDwuQIFcWqE9eDM3sV_wvV7SoF7efcZZrcCvyYFLe5" --header "Content-Type: application/json" --data "{\"url\":\"https://www.infobae.com/malditos-nerds/2024/03/05/destino-final-6-la-nueva-entrega-de-la-franquicia-se-prepara-para-iniciar-su-rodaje/\",\"features\":{\"metadata\":{}}}" "https://api.us-east.natural-language-understanding.watson.cloud.ibm.com/instances/c36e7ec0-b19c-4f02-ab6a-fab0a132757f/v1/analyze?version=2019-07-12"
```

## 🎓 Uso Avanzado
Explora las capacidades avanzadas de ```IBM Watson Natural Language Understanding``` para maximizar su potencial:

- ### 😊 Análisis de Emociones
  Detecta y analiza emociones en el texto.

- ### 🏙️ Extracción de Entidades
  Identifica entidades relevantes en el texto, como personas, lugares y organizaciones.

- ### 😞 Análisis de Sentimientos
  Determina el tono emocional del texto, como positivo, negativo o neutro.

- ### 💡 Análisis de Conceptos
  Extrae conceptos clave del texto para comprender su contenido.

## 📚 Documentación Adicional
Para obtener más información sobre el servicio y cómo utilizarlo, consulte la documentación adicional:

- **📘 Guía de Aprendizaje de Inicio:** [Comienza aquí](https://cloud.ibm.com/docs/services/natural-language-understanding?topic=natural-language-understanding-getting-started#getting-started-tutorial)
- **📖 Referencia de API:** [Consulta la documentación](https://cloud.ibm.com/apidocs/natural-language-understanding)
