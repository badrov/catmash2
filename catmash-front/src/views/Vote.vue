<template id='Vote'>
  <div>
    <h1>Pour quel chat voteras-tu?</h1>
    <div class="gallery">
      <gallery :images="randomCats" @close="index = null" />
      <div class="image"
           v-for="(cat, catIndex) in randomCats"
           :key="catIndex"
           @click="voteOne(cat)"
           :style="{ backgroundImage: 'url(' + cat.url + ')', width: '300px', height: '200px' }">
        <div class="score">{{cat.score}}</div>
      </div>
    </div>
  </div>
</template>

<script>
import Cat from '../components/Cat';
import { mapState } from 'vuex';
import VueGallery from 'vue-gallery';

export default {
  name: 'Vote',
  components: {
    gallery: VueGallery,
    Cat,
  },
  mounted() {
      this.loadGame();
  },
  computed: mapState([
      'randomCats',
  ]),
  methods: {
     voteOne(cat) {
         this.$store.dispatch('updateCat', cat.id)
         .then(() => {
             this.loadGame();
         });
     },
      loadGame() {
         this.$store.dispatch('getRandomCats', 2);
      },
  },
};
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
h1, h2 {
  font-weight: normal;
}
ul {
  list-style-type: none;
  padding: 0;
}
li {
  display: inline-block;
  margin: 0 10px;
}
a {
  color: #42b983;
}
* {
  box-sizing: border-box;
}

/* Create two equal columns that floats next to each other */
.column {
  float: left;
  width: 50%;
  padding: 10px;
}

button {
  background-color: #4c78af;
  border-radius: 8px;
  padding: 14px 40px;
  font-size: 25px;
  color: white;
  border: none;
}

.gallery {
  margin: auto;
  width: 50%;
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

</style>
