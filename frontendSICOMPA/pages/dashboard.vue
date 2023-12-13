<template>
    <div class="row">
        <div class="column col-6">
            <!-- Primer cuadrante -->
            <div class="card">
                <div class="card-content">
                  <p>Agregar un gasto: </p>
                  <v-text-field  variant="underlined" v-model="username" label="Monto"></v-text-field>

                  <v-text-field variant="underlined" v-model="password" label="Descripción"></v-text-field>
                  <v-text-field variant="underlined" v-model="password" label="Fecha "></v-text-field>
                  
                   
      

                    <v-form fast-fail @submit.prevent="pagar">

                        <v-btn type="submit" variant="outlined" color="#31B189" block class="mt-2">Subbir</v-btn>

                    </v-form>

                </div>
            </div>
        </div>
        <div class="column col-6">
            <!-- Segundo cuadrante -->
            <div class="card">
                <div class="card-content">
                    <h2>Estadísticas </h2>
                    <p>
                        <img
                            src="../static/estadisticas.png"
                            alt="Vuetify.js"
                            class="mb-5"
                        >
                    </p>
                    
                </div>
            </div>
        </div>
        <div class="column col-6">
            <!-- Segundo cuadrante -->
            <div class="card">
                <div class="card-content">
                    <h2>Información </h2>
                    <p>
                        <img
                            src="../static/estadisticas.png"
                            alt="Vuetify.js"
                            class="mb-5"
                        >
                    </p>
                    
                </div>
            </div>
        </div>
    </div>
    
    
    
    
        
    
    
    </template>
    
    <script>
    
    export default{
        layout: 'usuarioLayout',
        data() {
            return {
                monto: 50000,
            };
        },
       /*  mounted() {
        // Llamada a la API para obtener el valor de monto desde el backend
        this.obtenerMontoDesdeBackend();
      },
        methods: {
        async obtenerMontoDesdeBackend() {
          try {
            // Realizar una solicitud HTTP GET al endpoint correspondiente en tu backend
            const response = await axios.get('URL_DEL_BACKEND_ENDPOINT'); // Reemplaza 'URL_DEL_BACKEND_ENDPOINT' con tu URL real
    
            // Actualizar monto con el valor recibido del backend
            this.monto = response.data.monto; // Suponiendo que el valor se encuentra en una propiedad 'monto' dentro de la respuesta
          } catch (error) {
            console.error('Error al obtener el monto desde el backend:', error);
          }
        }
      } */
      methods: {
        pagar(){
            this.$router.push('/pago');
        }
    }
    
    }
    
    
    
    </script>
    
    <style scoped>
        .row {
            display: flex;
            flex-wrap: wrap;
            margin-left: 5px; /* Margen negativo para compensar el espacio entre las columnas */
            margin-right: 5px; /* Margen negativo para compensar el espacio entre las columnas */
          }
          
          .column {
            padding-left: 15px; /* Espacio entre columnas */
            padding-right: 15px; /* Espacio entre columnas */
            box-sizing: border-box; /* Para incluir padding en el ancho total de la columna */
          }
          
          .col-4 {
            flex: 0 0 50%; /* Ocupa el 33.333% del ancho del contenedor */
            max-width: 50%; /* Establece el ancho máximo */
          }
    
    .card {
      background-color: #fff;
      border-radius: 8px; /* Bordes redondeados */
      box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1); /* Sombra */
      padding: 20px; /* Espaciado interior */
      max-width: 500px; /* Ancho máximo de la tarjeta */
      margin: 0 auto; /* Centra la tarjeta horizontalmente */
    }
    
    .card-content {
      /* Estilos opcionales para el contenido dentro de la tarjeta */
    }
    
    /* Estilos adicionales */
    h2 {
      font-size: 24px;
      margin-bottom: 10px;
      color: black;
    }
    
    p {
      font-size: 16px;
      color: #555;
    }
    
    </style>
      