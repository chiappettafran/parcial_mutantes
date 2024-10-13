# Mutant Detection API

Este proyecto implementa una API para detectar si un humano es mutante basado en su secuencia de ADN. La API recibe secuencias de ADN mediante una petición HTTP POST y devuelve si el humano es mutante o no. Además, almacena las secuencias verificadas en una base de datos y expone estadísticas sobre las verificaciones realizadas.

## Despliegue
El proyecto se encuentra alojado en Render y podra accederse al mismo mediante el siguiente link.

https://mutanteschiappettafran.onrender.com

## Descripción del servicio

La API tiene dos servicios principales:

### 1. Detección de mutantes (`/mutant/`)

Este endpoint permite verificar si una secuencia de ADN pertenece a un mutante.

#### Solicitud:

- **Método:** `POST`
- **URL:** `/mutant/`
- **Formato de entrada (JSON):**
  ```json
  {
    "dna": ["ATGCGA", "CAGTGC", "TTATGT", "AGAAGG", "CCCCTA", "TCACTG"]
  }

- **Respuesta**:
**200 OK** si el ADN corresponde a un mutante.
**403 Forbidden** si el ADN no corresponde a un mutante.

## Endpoint: `/stats` [GET]

Este endpoint devuelve estadísticas sobre las verificaciones de ADN realizadas. Las estadísticas incluyen el número de secuencias de ADN de mutantes, el número de secuencias de ADN de humanos y el ratio de mutantes sobre humanos.

### Respuesta:

```json
{
  "count_mutant_dna": 40,
  "count_human_dna": 100,
  "ratio": 0.4
}
