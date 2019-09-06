<template id='CatGrid'>
  <div id="cat-grid">
    <h1>Grid of {{cats.length}} cats</h1>
    <gallery :images="cats"  @close="index = null"></gallery>
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
import axios from 'axios';
import Cat from '@/components/Cat';
import VueGallery from 'vue-gallery';

export default {
  name: 'catGrid',
  components: {
    gallery: VueGallery,
    Cat,
  },
  data() {
    return {
      cats: [],
    };
  },
  mounted() {
     axios({ method: 'GET', url: 'http://localhost:8080/cats' })
     .then( (result) => this.cats = result.data);
  },
  methods: {},
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
