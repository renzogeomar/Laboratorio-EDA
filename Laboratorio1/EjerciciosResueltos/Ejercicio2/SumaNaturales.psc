Algoritmo  SumaNaturales
    Definir N, i, suma Como Entero;
    Escribir "Ingrese un n�mero natural N:";
    Leer N;
    // Validar que N sea positivo
    Si N <= 0 Entonces
        Escribir "Por favor, ingrese un n�mero natural positivo.";
	FinSi
	suma <- 0;
	i <- 1;
	// Usar ciclo Mientras
	Mientras i <= N Hacer
		suma <- suma + i;
		i <- i + 1;
	FinMientras
	Escribir "La suma de los primeros ", N, " n�meros naturales es: ", suma;
FinAlgoritmo

