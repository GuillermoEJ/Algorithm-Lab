# 🎯 Laboratorio de Algoritmos - Visualizador Web

Una aplicación educativa interactiva para visualizar algoritmos de ordenamiento con **Spring Boot**, **Thymeleaf** y **JavaScript puro**.

## 📋 Características

- ✨ **Visualización en tiempo real** de algoritmos de ordenamiento
- 🎨 **Interfaz moderna** con animaciones suaves
- 📊 **Estadísticas detalladas** (comparaciones, intercambios, tiempo)
- 🎮 **Controles interactivos** (play, pausa, velocidad, tamaño del array)
- 📱 **Diseño responsivo** (funciona en móvil, tablet y desktop)
- 🎓 **Información educativa** de cada algoritmo

## 🔧 Algoritmos Incluidos

### Selection Sort
- **Complejidad**: O(n²)
- **Descripción**: Busca el elemento mínimo y lo coloca al inicio
- **Mejor caso**: O(n²)
- **Peor caso**: O(n²)

### Insertion Sort
- **Complejidad**: O(n²)
- **Descripción**: Construye el array ordenado incrementalmente
- **Mejor caso**: O(n)
- **Peor caso**: O(n²)

### Bubble Sort
- **Complejidad**: O(n²)
- **Descripción**: Los elementos "flotan" hacia su posición correcta
- **Mejor caso**: O(n)
- **Peor caso**: O(n²)

## 🚀 Requisitos

- **Java**: 17 o superior
- **Maven**: 3.8 o superior
- **Navegador moderno** con soporte para ES6

## 📦 Instalación

### 1. Clonar o descargar el proyecto

```bash
cd "c:\Users\Guillermo\Carpeta Maestra\Estudios\Apuntes UNI\4º\0 AL\0 Lab"
```

### 2. Compilar el proyecto

```bash
mvn clean install
```

### 3. Ejecutar la aplicación

```bash
mvn spring-boot:run
```

O directamente:

```bash
mvn clean spring-boot:run
```

### 4. Abrir en el navegador

```
http://localhost:8080
```

## 📁 Estructura del Proyecto

```
laboratorio-algoritmos/
├── pom.xml                                    # Dependencias Maven
├── src/
│   ├── main/
│   │   ├── java/com/algoritmos/
│   │   │   ├── App.java                      # Aplicación principal
│   │   │   ├── controller/
│   │   │   │   └── VisualizadorController.java
│   │   │   └── service/
│   │   │       └── OrdenacionService.java
│   │   └── resources/
│   │       ├── application.properties
│   │       ├── templates/
│   │       │   └── visualizador.html
│   │       └── static/
│   │           ├── css/style.css
│   │           └── js/visualizador.js
│   └── test/
├── .gitignore
└── README.md
```

## 🎮 Cómo Usar

### Interfaz

1. **Selecciona un algoritmo** usando los botones (Selection, Insertion, Bubble)
2. **Ajusta el tamaño** del array con el slider (5-100 elementos)
3. **Presiona Play** para iniciar la animación
4. **Pausa/Reanuda** cuando lo necesites
5. **Cambia la velocidad** del slider para acelerar o ralentizar
6. **Reinicia** para generar un nuevo array

### Colores

- 🔵 **Azul/Púrpura**: Elemento en su posición correcta
- 🟠 **Naranja**: Elemento siendo comparado
- 🔴 **Rojo**: Elemento siendo intercambiado
- 🟢 **Verde**: Elemento ya ordenado

### Estadísticas

- **Comparaciones**: Número de veces que se comparan dos elementos
- **Intercambios**: Número de veces que se intercambian elementos
- **Tiempo**: Tiempo transcurrido en milisegundos

## 🛠️ Configuración

### Editar puertos

En `application.properties`:

```properties
server.port=8080  # Cambiar por otro puerto si es necesario
```

### Habilitar/deshabilitar cache de templates

```properties
spring.thymeleaf.cache=false  # false para desarrollo, true para producción
```

## 🔍 Troubleshooting

### Error: "Maven is not installed"
```bash
# Descargar Maven desde https://maven.apache.org/download.cgi
# O usar Maven wrapper si está disponible
mvnw spring-boot:run
```

### Puerto 8080 ya está en uso
```bash
# Cambiar en application.properties o en línea de comandos
mvn spring-boot:run -Dspring-boot.run.arguments="--server.port=8081"
```

### Error de compilación Java
```bash
# Verificar versión de Java
java -version

# Debe ser 17 o superior
```

## 📚 Conceptos Educativos

Este proyecto ayuda a entender:

- **Complejidad computacional** (notación Big-O)
- **Comparación entre algoritmos** similares
- **Optimización de código** (casos mejores, peores y promedio)
- **Visualización de procesos** algorítmicos
- **Desarrollo web con Spring Boot**

## 🚀 Próximas Mejoras

- [ ] Añadir Quick Sort, Merge Sort, Heap Sort
- [ ] Comparativa en tiempo real entre algoritmos
- [ ] Exportar estadísticas
- [ ] Tema oscuro
- [ ] Más opciones de generación de arrays
- [ ] Pruebas unitarias

## 📝 Licencia

Proyecto educativo - Libre para usar y modificar

## 👨‍💻 Autor

Guillermo - Laboratorio de Algoritmos 4º

---

**¡Disfruta aprendiendo algoritmos de forma visual!** 🎓✨
