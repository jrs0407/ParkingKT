# 🅿️ Parking del Zaidín Vergeles 🚗 (Jetpack Compose)

Aplicación móvil en **Kotlin con Jetpack Compose** para la gestión de un estacionamiento. Permite visualizar el estado de las plazas, buscar vehículos por matrícula y acceder a la información de cada vehículo.

## 📜 Características Principales

✅ **Gestión de plazas de aparcamiento:** Consulta el estado de las plazas (ocupadas o disponibles).  
✅ **Búsqueda de vehículos por matrícula:** Encuentra información detallada sobre un vehículo en el parking.  
✅ **Navegación intuitiva entre pantallas:** Implementación de **Jetpack Navigation** para moverse fluidamente en la app.  
✅ **Uso de estado en Jetpack Compose:** Se gestiona el estado de las plazas a través de **ViewModel y mutableStateOf**.  
✅ **Integración con API externa mediante Retrofit:** Se obtienen datos desde un servidor remoto.  
✅ **Gráficos en tiempo real con WebSockets:** Se actualizan dinámicamente los datos del parking.  
✅ **Gráficos sin librerías externas:** Uso de **Canvas** para crear representaciones visuales de los datos.  

---

## ✅ Evaluación de Requisitos

| **Requisito** | **Cumple** |
|--------------|-----------|
| **1. Definición de Componentes y Gestión de Estados** | ✅ Sí |
| *Uso de ViewModel con mutableStateOf para la gestión de estados.* | ✅ Sí |
| **2. Navegación entre Pantallas** | ✅ Sí |
| *Implementación de Jetpack Navigation con argumentos en rutas.* | ✅ Sí |
| **3. Uso de Retrofit con LazyColumn o Similares** | ✅ Sí |
| *Retrofit está integrado y los datos se muestran en LazyVerticalGrid.* | ✅ Sí |
| **4. Uso de Biblioteca Externa para Gráficas** | ✅ Sí |
| *Se mostró en clase tanto a mano como con herramientas externas* | ✅ Sí |
| **5. Creación de un Componente de Gráficas sin Biblioteca Externa** | ✅ Sí |
| *Uso de Canvas para representar datos en forma de gráfica de barras.* | ✅ Sí |
| **6. Comunicación con un Servidor mediante WebSockets** | ✅ Sí |
| *Conexión con Socket.IO para actualizar los datos en tiempo real.* | ✅ Sí |
| **7. Uso de VerticalPager o Similar** | ❌ No se implementó |
| *No se ha utilizado VerticalPager o un componente similar.* | ❌ No |

