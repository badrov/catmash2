<template id='Vote'>
  <div>
    <h1>{{ msg }}</h1>
    <div class='row'>
      <button v-on:click='() => {displayScores()}'>Display scores</button>
    </div>
    <div class='row'>
      <div class='column'>
        <Cat :cat='leftCat' :action='(cat) => voteOne(cat)'/>
      </div>
      <div class='column'>
        <Cat :cat='rightCat' :action='(cat) => voteOne(cat)'/>
      </div>
    </div>
  </div>
</template>

<script>
import Cat from '@/components/Cat';
import axios from 'axios';

export default {
  name: 'Vote',
  components: {
    Cat,
  },

  data() {
    return {
      msg: 'Choose your favorite cat',
      leftCat: {url : ''},
      rightCat: {url : ''},
      cats : [],
    };
  },

  mounted() {
     axios({ method: 'GET', url: 'http://localhost:8080/cats' })
     .then((response) => {
        this.displayTwoCats(response);
     });
  },

  methods: {
     displayTwoCats(response) {
      this.cats = response.data;
      const catsCount = this.cats.length;

      const leftCatIndex = Math.floor((Math.random() * catsCount) + 1);
      this.leftCat = this.cats[leftCatIndex];

      let rightCatIndex = Math.floor((Math.random() * catsCount) + 1);
      if (leftCatIndex === rightCatIndex) {
        rightCatIndex = (rightCatIndex + 1) % catsCount;
      }
      this.rightCat = this.cats[rightCatIndex];
     },

     voteOne(cat) {
         console.log(cat.id);
         axios({ method: 'PUT', url: 'http://localhost:8080/cat/' + cat.id + '/vote' })
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
</style>
