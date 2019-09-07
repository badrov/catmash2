<template id='CatGrid'>
  <div id="cat-grid">
     <v-gallery :images="cats" @close="index = null" />
     <div class="image"
          v-for="(cat, catIndex) in cats"
          :key="catIndex"
          @click="index = catIndex"
          :style="{ backgroundImage: 'url(' + cat.url + ')', width: '300px', height: '200px' }">
       <div class="score">{{cat.score}}</div>
     </div>
  </div>
</template>

<script>
import VueGallery from 'vue-gallery';
import { mapState } from 'vuex';
export default {
  name: 'catGrid',
  components: {
    gallery: VueGallery,
  },
  mounted() {
      this.$store.dispatch('getCats');
  },
  computed: mapState([
      'cats',
  ]),
};
</script>

<style scoped>
  button {
    background-color: #4c78af;
    border-radius: 8px;
    padding: 14px 40px;
    font-size: 25px;
    color: white;
    border: none;
    margin-bottom: 10px;
    margin-top: 10px;
  }
  .image {
    float: left;
    background-size: cover;
    background-repeat: no-repeat;
    background-position: center center;
    border: 5px solid #b77b7b;
    margin: 5px;
    border-radius: 5%;
    border: 5px solid #b77b7b;
  }
  .score {
    cursor: default;
    bottom: 0px;
    right: 0px;
    border-radius: 50%;
    height: 2em;
    width: 2em;
    font-size: large;
    text-align: center;
    background-color: black;
    color: #42b983;
    box-shadow: 0px 0px 5px lightgrey;
    line-height: 2em;
    margin: 3px;
  }


</style>
