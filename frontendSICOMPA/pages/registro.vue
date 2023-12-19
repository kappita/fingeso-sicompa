<template>
    <div class = "Todo" >
    <v-row justify="space-between" align="center">
       <v-col cols="12">
        <v-card class="logo py-4 d-flex justify-center">
          <SICOMPALogo />
          
  
        </v-card>
      </v-col>
        <!-- <v-card> -->
          <v-col cols="6">
          <v-card-title class="headline" >
            
          </v-card-title>
          <div class = "login">
              <v-card-title class="headline">
              Bienvenid@ SICOMPA<br> 
  
              ¡Inicia sesión para pagar tus gastos comunes, ver estadísticas y mucho más!
            </v-card-title>
            <div class="d-flex align-center justify-center" style="height: 50vh">
            <v-sheet width="400" class="mx-autoo">
                <v-form fast-fail @submit.prevent="login">
                    <v-text-field  variant="underlined" v-model="username" label="Correo electronico"></v-text-field>
  
                    <v-text-field variant="underlined" v-model="password" label="Contraseña"></v-text-field>

                    <!-- REDIRIGIR A PÁGINA PARA PREGUNTAR CORREO -->
  
                    <v-btn type="submit" variant="outlined" color="#ffdda6" block class="mt-2">Crear cuenta</v-btn>
  
                </v-form>
                
            </v-sheet>
            </div>
  
          </div>
          <!-- <v-card-text>
            <p>Vuetify is a progressive Material Design component framework for Vue.js. It was designed to empower developers to create amazing applications.</p>
            <p>
              For more information on Vuetify, check out the <a
                href="https://vuetifyjs.com"
                target="_blank"
                rel="noopener noreferrer"
              >
                documentation
              </a>.
            </p>
            <p>
              If you have questions, please join the official <a
                href="https://chat.vuetifyjs.com/"
                target="_blank"
                rel="noopener noreferrer"
                title="chat"
              >
                discord
              </a>.
            </p>
            <p>
              Find a bug? Report it on the github <a
                href="https://github.com/vuetifyjs/vuetify/issues"
                target="_blank"
                rel="noopener noreferrer"
                title="contribute"
              >
                issue board
              </a>.
            </p>
            <p>Thank you for developing with Vuetify and I look forward to bringing more exciting features in the future.</p>
            <div class="text-xs-right">
              <em><small>&mdash; John Leider</small></em>
            </div>
            <hr class="my-3">
            <a
              href="https://nuxtjs.org/"
              target="_blank"
              rel="noopener noreferrer"
            >
              Nuxt Documentation
            </a>
            <br>
            <a
              href="https://github.com/nuxt/nuxt.js"
              target="_blank"
              rel="noopener noreferrer"
            >
              Nuxt GitHub
            </a>
          </v-card-text> -->
          <!-- <v-card-actions>
            <v-spacer />
            <v-btn
              color="primary"
              nuxt
              to="/inspire"
            >
              Continue
            </v-btn>
          </v-card-actions> -->
        <!-- </v-card> -->
      </v-col>
      
      <v-col cols="6" >
        <carouselInicio />
      </v-col>
    </v-row>
    
  </div>
  </template>
  
  <script>
  //import axios from 'axios';
  import SICOMPALogo from '../components/SICOMPALogo.vue';
  import carouselInicio from '../components/carouselInicio.vue';
  
  
  export default {
      name: 'IndexPage',
      layout: 'default',
      components: { SICOMPALogo , carouselInicio },
      data(){
          return{
              username: '',
              password: '',
              usuario: null,
          };
      },
      computed:{
        isvalid(){
          return this.username != '' && this.password != ''
        }
      },
      /* login(){
              this.$router.push('/dashboard'); */
      methods: {
        async guardarEnBaseDeDatos() {
      try {
        // Realizar una solicitud POST a tu servidor/API para guardar los datos en la base de datos
        const response = await axios.post('URL_DE_TU_API', {
          username: this.username,
          password: this.password,
        });

        // Si la solicitud fue exitosa y recibiste una respuesta del servidor
        console.log('Datos guardados en la base de datos:', response.data);

        // Puedes actualizar la variable usuario con los datos guardados, si es necesario
        this.usuario = response.data;

        // Realizar otras acciones después de guardar los datos, si es necesario
      } catch (error) {
        // Manejo de errores en caso de que la solicitud falle
        console.error('Error al guardar en la base de datos:', error);
      }
    }
  }
}
  </script>
  
  <style scoope >
  
  
  .logo {
    background-color: #31B189;
  }
  
  .Todo {
    /* background-color: #ffdda6; */
    width: 100%;
    height: 100%;
  }
  
  .login {
    background-color: #31B189;
    border-color: white ;
    border-radius: 5%;
    padding-left: 10%;
    margin-left: 80px; /* Ajusta el valor según sea necesario */
    height: 80% ;
  
    
  }
  .mx-autoo {
    background-color: #ffdda6;
    
  }
  
  
  /* Colores
  #ffc872 fuerte
  #ffdda6 claro */
  
  
  
  </style>
  