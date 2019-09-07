<template id='Vote'>
  <div>
    <h1>Pour quel chat voteras-tu?</h1>
    <div class='row'>
      <button v-on:click='() => {displayScores()}'>Go to score!</button>
    </div>
    <div class='row'>
      <div class='column' v-for='cat in randomCats' :key='cat.id'>
        <Cat :cat='cat' :action='(cat) => voteOne(cat)'/>
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
      this.$store.dispatch('getRandomCats', 2);
  },
  computed: mapState([
      'randomCats',
  ]),
  methods: {
     voteOne(cat) {
         this.$store.dispatch('updateCat', cat.id)
         .then(() => {
             this.$router.go();
         });
     },
     displayScores() {
        this.$router.push('cats');
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

.image {
  float: left;
  background-size: cover;
  background-repeat: no-repeat;
  background-position: center center;
  border: 1px solid #ebebeb;
  margin: 5px;
}

</style>
