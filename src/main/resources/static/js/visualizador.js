let algoritmoSeleccionado = null;
let arrayActual = [];
let animando = false;
let pausado = false;
let velocidad = 100;
let comparaciones = 0;
let intercambios = 0;
let tiempoInicio = 0;

// Información de algoritmos
const algoritmos = {
    selection: {
        nombre: 'Selection Sort',
        desc: 'Encuentra el elemento mínimo y lo coloca en su posición correcta',
        complejidad: 'O(n²)',
        info: 'Selection Sort busca el elemento más pequeño en el array no ordenado y lo coloca al principio. Repite este proceso hasta ordenar todo el array. Es simple pero ineficiente para arrays grandes.',
        mejorCaso: 'O(n²)',
        peorCaso: 'O(n²)',
        casoPromedio: 'O(n²)'
    },
    insertion: {
        nombre: 'Insertion Sort',
        desc: 'Construye el array ordenado de forma incremental, elemento por elemento',
        complejidad: 'O(n²)',
        info: 'Insertion Sort toma cada elemento e lo inserta en su posición correcta en la parte ya ordenada. Funciona como ordenar cartas en una mano. Es muy eficiente para arrays pequeños o casi ordenados.',
        mejorCaso: 'O(n)',
        peorCaso: 'O(n²)',
        casoPromedio: 'O(n²)'
    },
    bubble: {
        nombre: 'Bubble Sort',
        desc: 'Los elementos "flotan" hacia su posición correcta comparando pares adyacentes',
        complejidad: 'O(n²)',
        info: 'Bubble Sort compara elementos adyacentes e los intercambia si están en orden incorrecto. Repite este proceso hasta que no haya más intercambios. Es educativo pero muy ineficiente.',
        mejorCaso: 'O(n)',
        peorCaso: 'O(n²)',
        casoPromedio: 'O(n²)'
    },
    quick: {
        nombre: 'Quick Sort (Divide y Vencerás)',
        desc: 'Divide el array usando un pivote y ordena recursivamente las particiones',
        complejidad: 'O(n log n) promedio',
        info: 'Quick Sort es un algoritmo de Divide y Vencerás. Elige un elemento pivote, particiona el array en elementos menores y mayores que el pivote, luego aplica recursivamente el algoritmo. Muy eficiente en la práctica.',
        mejorCaso: 'O(n log n)',
        peorCaso: 'O(n²)',
        casoPromedio: 'O(n log n)'
    }
};

// Generar array aleatorio
function generarArray(tamaño) {
    return Array.from({length: tamaño}, () => Math.floor(Math.random() * 100) + 1);
}

// Dibujar barras
function dibujarBarras(array, colores = {}) {
    const contenedor = document.getElementById('barras');
    contenedor.innerHTML = '';
    
    const maxValor = Math.max(...array);
    
    array.forEach((valor, idx) => {
        const barra = document.createElement('div');
        barra.className = 'barra';
        if (colores[idx]) barra.classList.add(colores[idx]);
        barra.style.height = (valor / maxValor * 100) + '%';
        barra.textContent = array.length <= 30 ? valor : '';
        contenedor.appendChild(barra);
    });
}

// Esperar (para animaciones)
function esperar(ms) {
    return new Promise(resolve => setTimeout(resolve, ms));
}

// Selection Sort animado
async function selectionSortAnimado(array) {
    comparaciones = 0;
    intercambios = 0;
    tiempoInicio = Date.now();
    
    for (let i = 0; i < array.length; i++) {
        if (!animando) return;
        while (pausado) await esperar(100);
        
        let minIdx = i;
        
        for (let j = i + 1; j < array.length; j++) {
            if (!animando) return;
            while (pausado) await esperar(100);
            
            comparaciones++;
            
            // Marcar comparación
            let colores = {};
            for (let k = 0; k < i; k++) colores[k] = 'ordenado';
            colores[j] = 'comparando';
            colores[minIdx] = 'comparando';
            dibujarBarras(array, colores);
            actualizarStats();
            
            await esperar(510 - velocidad);
            
            if (array[j] < array[minIdx]) {
                minIdx = j;
            }
        }
        
        // Intercambiar
        if (minIdx !== i) {
            intercambios++;
            [array[i], array[minIdx]] = [array[minIdx], array[i]];
            
            let colores = {};
            for (let k = 0; k < i; k++) colores[k] = 'ordenado';
            colores[i] = 'intercambiando';
            colores[minIdx] = 'intercambiando';
            dibujarBarras(array, colores);
            actualizarStats();
            await esperar(510 - velocidad);
        }
        
        let colores = {};
        for (let k = 0; k <= i; k++) colores[k] = 'ordenado';
        dibujarBarras(array, colores);
        actualizarStats();
        await esperar(510 - velocidad);
    }
    
    // Marcar todo como ordenado
    let colores = {};
    for (let i = 0; i < array.length; i++) colores[i] = 'ordenado';
    dibujarBarras(array, colores);
    actualizarStats();
}

// Insertion Sort animado
async function insertionSortAnimado(array) {
    comparaciones = 0;
    intercambios = 0;
    tiempoInicio = Date.now();
    
    for (let i = 1; i < array.length; i++) {
        if (!animando) return;
        while (pausado) await esperar(100);
        
        let aux = array[i];
        let j = i;
        
        while (j > 0) {
            if (!animando) return;
            while (pausado) await esperar(100);
            
            comparaciones++;
            
            let colores = {};
            for (let k = 0; k < i; k++) colores[k] = 'ordenado';
            colores[j] = 'comparando';
            if (j - 1 >= 0) colores[j - 1] = 'comparando';
            dibujarBarras(array, colores);
            actualizarStats();
            
            await esperar(510 - velocidad);
            
            if (array[j - 1] > aux) {
                intercambios++;
                array[j] = array[j - 1];
                j--;
                
                let coloresInt = {};
                for (let k = 0; k < i; k++) coloresInt[k] = 'ordenado';
                coloresInt[j] = 'intercambiando';
                coloresInt[j + 1] = 'intercambiando';
                dibujarBarras(array, coloresInt);
                await esperar(510 - velocidad);
            } else {
                break;
            }
        }
        
        array[j] = aux;
        
        let colores = {};
        for (let k = 0; k <= i; k++) colores[k] = 'ordenado';
        dibujarBarras(array, colores);
        actualizarStats();
    }
    
    let colores = {};
    for (let i = 0; i < array.length; i++) colores[i] = 'ordenado';
    dibujarBarras(array, colores);
    actualizarStats();
}

// Bubble Sort animado
async function bubbleSortAnimado(array) {
    comparaciones = 0;
    intercambios = 0;
    tiempoInicio = Date.now();
    
    for (let i = 0; i < array.length; i++) {
        if (!animando) return;
        
        for (let j = 0; j < array.length - i - 1; j++) {
            if (!animando) return;
            while (pausado) await esperar(100);
            
            comparaciones++;
            
            let colores = {};
            colores[j] = 'comparando';
            colores[j + 1] = 'comparando';
            for (let k = array.length - i; k < array.length; k++) colores[k] = 'ordenado';
            dibujarBarras(array, colores);
            actualizarStats();
            
            await esperar(510 - velocidad);
            
            if (array[j] > array[j + 1]) {
                intercambios++;
                [array[j], array[j + 1]] = [array[j + 1], array[j]];
                
                let coloresInt = {};
                coloresInt[j] = 'intercambiando';
                coloresInt[j + 1] = 'intercambiando';
                for (let k = array.length - i; k < array.length; k++) coloresInt[k] = 'ordenado';
                dibujarBarras(array, coloresInt);
                await esperar(510 - velocidad);
            }
        }
        
        let colores = {};
        for (let k = array.length - i - 1; k < array.length; k++) colores[k] = 'ordenado';
        dibujarBarras(array, colores);
    }
    
    let colores = {};
    for (let i = 0; i < array.length; i++) colores[i] = 'ordenado';
    dibujarBarras(array, colores);
    actualizarStats();
}

// Quick Sort animado (Divide y Vencerás)
async function quickSortAnimado(array) {
    comparaciones = 0;
    intercambios = 0;
    tiempoInicio = Date.now();
    
    await quickSortAux(array, 0, array.length - 1);
    
    let colores = {};
    for (let i = 0; i < array.length; i++) colores[i] = 'ordenado';
    dibujarBarras(array, colores);
    actualizarStats();
}

async function quickSortAux(array, i0, iN) {
    if (!animando) return;
    while (pausado) await esperar(100);
    
    if (i0 >= iN) return;
    
    let m = await ordenarPivoteAnimado(array, i0, iN);
    await quickSortAux(array, i0, m - 1);
    await quickSortAux(array, m + 1, iN);
}

async function ordenarPivoteAnimado(array, i0, iN) {
    let pivote = array[iN];
    let i = i0;
    let j = iN - 1;
    
    while (i < j) {
        if (!animando) return i0;
        while (pausado) await esperar(100);
        
        while (array[i] <= pivote && i < j) {
            if (!animando) return i0;
            comparaciones++;
            
            let colores = {};
            colores[i] = 'comparando';
            colores[iN] = 'comparando';
            dibujarBarras(array, colores);
            actualizarStats();
            
            await esperar(510 - velocidad);
            i++;
        }
        
        while (array[j] > pivote && i < j) {
            if (!animando) return i0;
            comparaciones++;
            
            let colores = {};
            colores[j] = 'comparando';
            colores[iN] = 'comparando';
            dibujarBarras(array, colores);
            actualizarStats();
            
            await esperar(510 - velocidad);
            j--;
        }
        
        if (i < j) {
            intercambios++;
            let aux = array[i];
            array[i] = array[j];
            array[j] = aux;
            
            let colores = {};
            colores[i] = 'intercambiando';
            colores[j] = 'intercambiando';
            dibujarBarras(array, colores);
            actualizarStats();
            
            await esperar(510 - velocidad);
        }
    }
    
    if (array[i] > pivote) {
        intercambios++;
        array[iN] = array[i];
        array[i] = pivote;
        
        let colores = {};
        colores[iN] = 'intercambiando';
        colores[i] = 'intercambiando';
        dibujarBarras(array, colores);
        actualizarStats();
        
        await esperar(510 - velocidad);
        return i;
    } else {
        return iN;
    }
}

// Actualizar estadísticas
function actualizarStats() {
    document.getElementById('stat-comparaciones').textContent = comparaciones;
    document.getElementById('stat-intercambios').textContent = intercambios;
    
    const tiempoTranscurrido = Date.now() - tiempoInicio;
    document.getElementById('stat-tiempo').textContent = tiempoTranscurrido + 'ms';
}

// Seleccionar algoritmo
async function seleccionarAlgoritmo(nombre) {
    if (animando) return;
    
    algoritmoSeleccionado = nombre;
    const algo = algoritmos[nombre];
    
    document.getElementById('algoritmo-titulo').textContent = algo.nombre;
    document.getElementById('algoritmo-desc').textContent = algo.desc;
    document.getElementById('info-completa').innerHTML = `
        <p><strong>Complejidad Promedio:</strong> ${algo.complejidad}</p>
        <p><strong>Mejor Caso:</strong> ${algo.mejorCaso}</p>
        <p><strong>Peor Caso:</strong> ${algo.peorCaso}</p>
        <p><strong>Descripción:</strong> ${algo.info}</p>
    `;
    
    arrayActual = generarArray(parseInt(document.getElementById('tamaño').value));
    dibujarBarras(arrayActual);
    comparaciones = 0;
    intercambios = 0;
    actualizarStats();
    
    document.getElementById('btn-play').disabled = false;
}

// Play
async function jugar() {
    if (!algoritmoSeleccionado || animando) return;
    
    animando = true;
    pausado = false;
    document.getElementById('btn-play').disabled = true;
    document.getElementById('btn-pausa').disabled = false;
    document.getElementById('tamaño').disabled = true;
    
    if (algoritmoSeleccionado === 'selection') {
        await selectionSortAnimado(arrayActual);
    } else if (algoritmoSeleccionado === 'insertion') {
        await insertionSortAnimado(arrayActual);
    } else if (algoritmoSeleccionado === 'bubble') {
        await bubbleSortAnimado(arrayActual);
    } else if (algoritmoSeleccionado === 'quick') {
        await quickSortAnimado(arrayActual);
    }
    
    animando = false;
    document.getElementById('btn-play').disabled = false;
    document.getElementById('btn-pausa').disabled = true;
    document.getElementById('tamaño').disabled = false;
    document.getElementById('btn-pausa').textContent = '⏸ Pausa';
    pausado = false;
}

// Pausa
function pausar() {
    pausado = !pausado;
    document.getElementById('btn-pausa').textContent = pausado ? '▶ Reanudar' : '⏸ Pausa';
}

// Reiniciar
function reiniciar() {
    animando = false;
    pausado = false;
    if (algoritmoSeleccionado) {
        arrayActual = generarArray(parseInt(document.getElementById('tamaño').value));
        dibujarBarras(arrayActual);
        comparaciones = 0;
        intercambios = 0;
        actualizarStats();
    }
    document.getElementById('btn-play').disabled = false;
    document.getElementById('btn-pausa').disabled = true;
    document.getElementById('btn-pausa').textContent = '⏸ Pausa';
    document.getElementById('tamaño').disabled = false;
}

// Cambiar velocidad
function cambiarVelocidad(valor) {
    velocidad = parseInt(valor);
    const porcentaje = Math.round((velocidad / 500) * 100);
    document.getElementById('velocidad-valor').textContent = porcentaje + '%';
}

// Actualizar tamaño
document.getElementById('tamaño').addEventListener('input', function() {
    document.getElementById('tamaño-valor').textContent = this.value;
    if (!animando) {
        reiniciar();
    }
});

// Inicialización
document.addEventListener('DOMContentLoaded', function() {
    document.getElementById('velocidad-valor').textContent = '100%';
});
