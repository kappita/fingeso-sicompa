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
            <div class ="registro">
              <v-sheet class="mx-auto" v-bind:class="responsiveWidth">
              <v-form fast-fail @submit.prevent="login">
                  <v-text-field  variant="underlined" v-model="email" label="Correo electrónico"></v-text-field>

                  <v-text-field variant="underlined" v-model="password" label="Contraseña"></v-text-field>
                  <br>
                      <br>


                      <label for="tipo-usuario">Selecciona tu rol :  </label>
                      <select v-model ="rolSeleccionado" name="tipo-usuario" id="tipo-usuario">
                      <option value="residente">Residente </option>
                      <option value="administrador">Administrador </option>
                      <option value="superadministrador">Super administrador</option>
                      </select>
                      <br>
                      <br>
                      <br>

                  <!-- REDIRIGIR A PÁGINA PARA PREGUNTAR CORREO -->
                  <a href="#" class="text-body-2 font-weight-regular">¿Olvidaste tu contraseña?</a>
                  <br>
                      <br>

                  <v-btn type="submit" variant="outlined" color="#ffdda6" block class="mt-2">Iniciar Sesión</v-btn>
                  <br>
                      <br>

              </v-form>
              <div class="mt-2">
                <!-- REFERIR A PÁGINA DE REGISTRO -->
                  <p class="text-body-2">Si aún no tienes una cuenta, <a href="/registro">¡únetenos!</a></p>
              </div>
          </v-sheet>

            </div>
            
          </div>

        </div>

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
import {store} from "../store/store"


export default {
    name: 'IndexPage',
    layout: 'default',
    components: { SICOMPALogo , carouselInicio }, 
    
    data(){
        return{
          rolSeleccionado: '',
          responsiveWidth: 'xs12 sm8 md6',
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
      login: async function() {
        const data = {
          email: this.email,
          password: this.password
        }
        let response;
        switch (this.rolSeleccionado) {
          case 'residente':
            console.log(data)
            response = this.$axios.post('http://localhost:8080/resident/login', data).then( e=> {
              console.log(e.data.user.username)
              store.username = e.data.user.username
              store.quota = e.data.residents[0].quota.resident_quota
              store.community_quota = e.data.residents[0].quota.community_quota
              store.usage_percentage = e.data.residents[0].quota.usage_percentage
              console.log(response)
            this.redireccionar('/dashboard')
            })
            break;

          case 'administrador':
            response = this.$axios.post('http://localhost:8080/admin/login', data).then( e=> {
            console.log(e.data.user.username)
            store.username = e.data.user.username
            store.email = e.data.user.email
            store.password = e.data.user.password
            store.community_id = e.data.admins[0].community_id

            console.log(response)
            this.redireccionar('/admin')
            })
            break;
            
          
        }
        
      },

      iniciarSesion() {
      // Dependiendo del valor de rolSeleccionado, redirigir a diferentes rutas
      switch (this.rolSeleccionado) {
        case 'residente':
          this.redireccionar('/ruta-para-residente');
          break;
        case 'administrador':
          this.redireccionar('/ruta-para-administrador');
          break;
        case 'superadministrador':
          this.redireccionar('/ruta-para-superadmin');
          break;
        default:
          // Manejar un caso por defecto si es necesario
          break;
      }
    },
    redireccionar(ruta) {
      // Usar el enrutador de Vue Router para redirigir a la ruta especificada
      this.$router.push({ path: ruta });
    },

    enviarRol() {
      // Aquí puedes utilizar Axios para enviar el valor seleccionado a tu servidor o realizar alguna acción con él
      axios.post('URL_DEL_SERVIDOR', { rol: this.rolSeleccionado })
        .then(response => {
          console.log('¡Valor enviado con éxito!', response.data);
          // Aquí puedes manejar la respuesta del servidor si es necesario
        })
        .catch(error => {
          console.error('Error al enviar el valor:', error);
          // Manejo de errores, si es necesario
        });
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
  border-color: rgb(255, 255, 255) ;
  border-radius: 5%;
  padding-left: 10%;
  padding-right: 10%;
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
