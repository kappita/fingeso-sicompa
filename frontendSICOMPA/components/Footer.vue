<template>
    <v-footer class="custome-footer">
      <v-row justify="center" no-gutters>
        <v-btn
          v-for="link in links"
          :key="link"
          color="red"
          variant="text"
          class="mx-2"
          rounded="xl"
        >
          {{ link }}
        </v-btn>
        <v-col class="text-center mt-4" cols="12">
          {{ new Date().getFullYear() }} — <strong>SICOMPA</strong>
        </v-col>
      </v-row>
    </v-footer>
  </template>
  
  <script>
    export default {
      data: () => ({
        links: [
          'Inicio',
          'Sobre Nosotros',
          'Equipo',
          'Servicios',
          'Contáctanos',
        ],
      }),
    }
  </script>
  
<style scoped>
.custome-footer{
    background-color: #1509c0;

}
  