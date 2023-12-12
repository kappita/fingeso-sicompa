<template> 

<!-- LOGIN -->
<section class="vh-100 gradient-custom">

  <div class="container-fluid">
    <div class="row">
      <div class="col-sm-6 text-black">

        <div class="px-5 ms-xl-4">
          <i class="fas fa-crow fa-2x me-3 pt-5 mt-xl-4" style="color: #709085;"></i>
          <span class="h1 fw-bold mb-0">¡Bienvenidd@s!</span>
        </div>

        <div class="d-flex align-items-center h-cust                            om-2 px-5 ms-xl-4 mt-5 pt-5 pt-xl-0 mt-xl-n5">

          <form style="width: 23rem;">

            <h3 class="fw-normal mb-3 pb-3" style="letter-spacing: 1px;">Ingresar</h3>

            <div class="form-outline mb-4">
              <input type="email" id="form2Example18" class="form-control form-control-lg" />
              <label class="form-label" for="form2Example18">Correo Electrónico</label>
            </div>

            <div class="form-outline mb-4">
              <input type="password" id="form2Example28" class="form-control form-control-lg" />
              <label class="form-label" for="form2Example28">Contraseña</label>
            </div>
            <div class="form-outline mb-4">
              <input type="password" id="form2Example28" class="form-control form-control-lg" />
              <label class="form-label" for="form2Example28">Rol</label>
            </div>

            <div class="btn-custom"  >
              <div class="pt-1 mb-4" >
                <a  href=/Home.vue class="btn btn-custom"   type="button" style="color: white;">Ingresar </a>
              </div>
            </div>

            <p class="small mb-5 pb-lg-2"><a class="text-muted" href="#!">¿Olvidaste tu contraseña?</a></p>

            <!-- Mensaje emergente -->
            <div id="mensajeEmergente" style="display: none;">
              <p>¡Olvidaste tu contraseña! Aquí puedes recuperarla.</p>
            </div>

            <!-- <p>Don't have an account? <a href="#!" class="link-info">Register here</a></p> -->

          </form>

        </div>

      </div>
      <div class="col-sm-6 px-0 d-none d-sm-block">
        <img src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-login-form/img3.webp"
          alt="Login image" class="w-100 vh-100" style="object-fit: cover; object-position: left;">
      </div>
    </div>
  </div>
</section>

  <main>
    <!-- <TheWelcome/> -->
  </main>
</template>


<script setup>
//import HelloWorld from './components/HelloWorld.vue'
//import TheWelcome from './components/TheWelcome.vue'
//import sideMenu from './components/sideMenu.vue';


</script>

<style>


.bg-image-vertical {
position: relative;
overflow: hidden;
background-repeat: no-repeat;
background-position: right center;
background-size: auto 100%;
}

@media (min-width: 1025px) {
.h-custom-2 {
height: 100%;
}
}

.gradient-custom {
background: #FFE3B3;
background: -webkit-linear-gradient(to right, rgb(255, 227, 179), rgb(122, 206, 98));
background: linear-gradient(to right, rgb(255, 227, 179), rgba(122, 206, 98))
}

.btn-custom{
  background-color: #31b189;
  border-color: white;
  border-radius: 80px;
}

</style>
