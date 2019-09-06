<template id='Vote'>
  <div>
    <h1>{{ msg }}</h1>
    <div class='row'>
      <button v-on:click='() => {displayScores()}'>Go to score!</button>
    </div>
    <div class='row'>
      <div class='column' v-for='cat in cats' :key='cat.id'>
        <Cat :cat='cat' :action='(cat) => voteOne(cat)'/>
      </div>
    </div>
  </div>
</template>

<script>
import Cat from '@/components/Cat';
import axios from 'axios';
import VueGallery from 'vue-gallery';

export default {
  name: 'Vote',
  components: {
    gallery: VueGallery,
    Cat,
  },

  data() {
    return {
      msg: 'Pour quel chat voteras-tu?',
      cats: [],
    };
  },

  mounted() {
     axios({ method: 'GET', url: 'http://localhost:8080/cats/random?count=2' })
     .then((response) => {
        this.displayTwoCats(response.data);
     });
  },

  methods: {
     displayTwoCats(cats) {
      this.cats = cats;
     },

     voteOne(cat) {
         axios({ method: 'PUT', url: 'http://localhost:8080/cat/' + cat.id })
         .then((response) => {
            this.refreshVoteScreen();
         });
     },

     displayScores() {
        this.$router.push('catGrid');
     },

     refreshVoteScreen() {
         this.$router.go();
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
