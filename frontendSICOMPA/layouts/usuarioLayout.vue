<template>
  <div>
  <div>
    <nav class="navbar">
      <div class="navbar-header">
      <button @click="toggleMenu" class="menu-toggle">&#9776;</button>
      <router-link to="/" class="navbar-brand">SICOMPA</router-link>
      </div>
      <div :class="['nav', { 'show-menu': showMenu }]">
        <router-link to="/" class="nav-item">Tú información</router-link>
        <router-link to="/about" class="nav-item">Avisos</router-link>
        <router-link to="/services" class="nav-item">Enviar Mensajes</router-link>
        <router-link to="/contact" class="nav-item">Votaciones</router-link>
      </div>
    </nav>
    <div class="content">
      <!-- Contenido de la página -->
      <router-view></router-view>
    </div>
  </div>
  <div class="footer">
      <v-footer class="bg-grey-lighten-1">
      <v-row justify="center" no-gutters>
        <router-link
      v-for="link in links"
      :key="link.id"
      :to="link.route"
      class="mx-4"
    >
      <v-btn
        color="red"
        variant="text"
        rounded
      >
        {{ link.text }}
      </v-btn>
    </router-link>
        <v-col  cols="12">
          <div class="text-center mt-4">
            {{ new Date().getFullYear() }} — <strong>SICOMPA</strong>
           </div>
        </v-col>
      </v-row>
    </v-footer>
    </div>
  </div>
</template>
<script>
export default {
  data() {
    return {
      showMenu: false,
      links: [
        {id:1,text:'Inicio', route:'/'},
        {id:2,text:'Sobre Nosotros',route:"/sobreNosotros"},
        {id:3,text:'Equipo',route:" /equipo"},
        {id:4,text:'Servicios',route:" /sobreNosotros"},
        {id:5,text:'Contáctanos',route:" /"},
      ],
    };
  },
  methods: {
    toggleMenu() {
      this.showMenu = !this.showMenu;
    }
  }
};
</script>



<style scoope>

/* Estilos para el navbar */
.navbar {
  background-color: #31B189;
  color: #fff;
  padding: 10px 0;
}

.navbar-header {
  display: flex;
  align-items: center;
}


.menu-toggle {
  background: none;
  border: none;
  color: #ffffff;
  font-size: 24px;
  cursor: pointer;
  margin-right: 10px;
  margin-left:1%
}

.nav {
  display: none;
  flex-direction: column;
  margin-left: 1%;
}

.show-menu {
  display: flex;
  margin-left: 1%;
}


.footer {
  position: fixed;
  bottom: 0;
  width: 100%;
}

.mx-4 {
  
  margin-left: 1.5rem;
  margin-left: 10%;
}
.text-center {
  margin-left: 50%;
}
.bg-grey-lighten-1 {
  background-color: #ffdda6;
}


/* Estilos adicionales según sea necesario */

body {
  font-family: Arial, sans-serif;
  margin: 0;
  padding: 0;
}



.container {
  display: flex;
  justify-content: space-between;
  align-items: center;
}

.navbar-header {
  margin-right: 20px;
}

/*Título SICOMPA*/
.navbar-brand {
  color: #ffffff;
  text-decoration: none;
  font-size: 24px;
  font-weight: bold;
}

.nav {
  list-style: none;
  margin: 0;
  padding: 0;
}

.nav li {
  display: inline;
}

.nav a {
  color: #fff;
  text-decoration: none;
  margin: 0 10px;
  font-size: 18px;
}

.content {
  padding: 60px;
}

</style>
