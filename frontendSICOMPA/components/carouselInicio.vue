<template>
    <div class="carouselImageStyle">
    <v-carousel :show-arrows="false">
      <v-carousel-item v-for="(item, i) in items" :key="i">
        <img :src="item.src" class="foto" />
      </v-carousel-item>
    </v-carousel>
</div>
  </template>
  
  <script>
    export default {
      data () {
        return {
          items: [
            {
              src: 'https://concepto.de/wp-content/uploads/2013/03/comunidad-1-800x422.jpeg',
            },
            
          ],
        }
      },
    }
  </script>


<style scoped>

.carouselImageStyle {
    margin: 50px;
      }

.foto{
    border-radius: 15px;
    border-top-right-radius: 15px;
    border-bottom-left-radius: 15px;
    border-bottom-right-radius: 15px;
}
</style>