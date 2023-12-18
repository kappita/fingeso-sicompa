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
                  <v-text-field  variant="underlined" v-model="username" label="Usuario"></v-text-field>

                  <v-text-field variant="underlined" v-model="password" label="Contraseña"></v-text-field>
                  <!-- CAMBIAR EL MODELO!!! -->
                  <v-select
                      v-model="usuario"
                      :items="opciones"
                      label="Rol"
                      @change="redireccionar"
                    ></v-select>
                  <!-- REDIRIGIR A PÁGINA PARA PREGUNTAR CORREO -->
                  <a href="#" class="text-body-2 font-weight-regular">¿Olvidaste tu contraseña?</a>

                  <v-btn type="submit" variant="outlined" color="#ffdda6" block class="mt-2">Iniciar Sesión</v-btn>

              </v-form>
              <div class="mt-2">
                <!-- REFERIR A PÁGINA DE REGISTRO -->
                  <p class="text-body-2">Si aún no tienes una cuenta, <a href="/registro">¡únetenos!</a></p>
              </div>
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
import SICOMPALogo from '../components/SICOMPALogo.vue';
import carouselInicio from '../components/carouselInicio.vue';
import axios from "axios"


export default {
    name: 'IndexPage',
    layout: 'default',
    components: { SICOMPALogo , carouselInicio },
    data(){
        return{
            username: '',
            password: '',
            usuario: null,
      opciones: [
      { text: 'Residente', value: 'opcion1' },
        { text: 'Administrador', value: 'opcion2' },
        { text: 'Super Administrador', value: 'opcion3' },
      ]
        };
    },
    methods: {
        async login(){
            axios.get("https://catfact.ninja/fact").then((c) => {
              console.log(c.data)
            })
            this.$router.push('/dashboard');
        },
        redireccionar(){
          switch (this.selectedOption) {
        case 'opcion1':
          this.$router.push('/dashboard');
          break;
        case 'opcion2':
          this.$router.push('/admin');
          break;
        case 'opcion3':
          this.$router.push('/ruta-de-la-opcion-3');
          break;
      }

    }
    }
}
</script>

<style scoope >


/* .logo {
   background-color: #ffc872; 
} */

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
