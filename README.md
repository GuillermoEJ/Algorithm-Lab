# Laboratorio de Algoritmos Educativo

Repositorio con implementaciones de algoritmos fundamentales organizados en tres paradigmas de diseño.

---

## MODULO 1: Ordenacion Basica

**Concepto:** Algoritmos que reordenan elementos aplicando comparaciones e intercambios.

**Algoritmos:**
- Selection Sort - O(n²) siempre
- Insertion Sort - O(n²) promedio, O(n) mejor caso
- Bubble Sort - O(n²) siempre
- Bubble Sort Optimizado - O(n) mejor caso con bandera

**Cuando usarlo:** Para entender cómo funcionan los algoritmos básicos y aprender sobre complejidad.

**Ejecutar:**
```java
ejerciciosOrdenacion();
```

---

## MODULO 2: Divide y Venceras

**Concepto:** Divide el problema en subproblemas más pequeños, las resuelve recursivamente y combina resultados.

**Algoritmos:**
- Busqueda Binaria - O(log n)
- Quick Sort - O(n log n) promedio
- Maximo Subarray - O(n log n)
- Quick Select - O(n) promedio
- Plus 10+ problemas adicionales

**Cuando usarlo:** Para problemas que se pueden descomponer de forma recursiva.

**Ejecutar:**
```java
ejerciciosDivideYVenceras();
```

---

## MODULO 3: Backtracking

**Concepto:** Explora todas las combinaciones posibles de forma recursiva, podando ramas inútiles.

**Algoritmos:**
- Suma de Subconjuntos - Encontrar subconjunto con suma exacta
- Viaje del Caballero - Recorrido completo en tablero sin repetir
- Problema N-Reinas - Colocar N reinas sin que se amenacen
- Mochila Optima - Maximizar valor con peso limitado
- Cambio Optimo - Minimo numero de monedas
- Camino con Coste Exacto - Ruta con longitud específica
- Coloreo de Grafos - Colorear vertices con minimos colores

**Cuando usarlo:** Para problemas combinatorios y de búsqueda exhaustiva.

**Ejecutar:**
```java
sumaEnterosBack();      // Subconjuntos
viajeCaballero();       // Caballero
nReinas();              // N-Reinas
mochilaOptima();        // Mochila
monedasOptimo();        // Monedas
caminoCosteExacto();    // Ruta
colorearGrafo();        // Grafos
```

---

## Como Usar

1. Abre `Main.java`
2. Llama el metodo del algoritmo que quieres probar
3. Ejecuta con Java

**Requisitos:** Java 8 o superior

**Estructura:**
```
Laboratorio/
├── Main.java           (Punto de entrada y ejemplos)
├── Generador.java      (Utilidades para arrays)
├── Mod1_Sort/          (Ordenacion)
├── Mod2_DyV/           (Divide y Venceras)
└── Mod3_BackTracking/  (Backtracking)
```

---

## Utilidades

La clase `Generador` proporciona:
- `generarArrayAleatorio()` - Valores aleatorios
- `generarArrayCasiOrdenado()` - Array casi ordenado
- `generarArrayInverso()` - Array en orden inverso
- `generarArrayConDuplicados()` - Array con duplicados
- `estaOrdenado()` - Verifica orden
- `imprimirArray()` - Imprime en consola
- `imprimirMatriz()` - Imprime matrices
- `imprimirTablero()` - Imprime tableros

---

**Version:** 1.0  
**Uso:** Educativo
