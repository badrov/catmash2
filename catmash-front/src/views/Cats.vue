<template id='CatGrid'>
  <div id="cat-grid">
    <h1>Grid of {{cats.length}} cats</h1>
    <gallery :images="cats" @close="index = null" />
     <div
       class="image"
       v-for="(cat, catIndex) in cats"
       :key="catIndex"
       @click="index = catIndex"
       :style="{ backgroundImage: 'url(' + cat.url + ')', width: '300px', height: '200px' }">
        <div id='progressbar'>
          <progress :value='cat.score' min='0' max='100'></progress>
        </div>
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
    border: 1px solid #ebebeb;
    margin: 5px;
  }
</style>
