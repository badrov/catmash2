<template id='CatGrid'>
  <div id="cat-grid">
    <h1>Gallery of {{cats.length}} cats</h1>
    <ul v-if='cats.length'>
      <div v-for='cat in cats' :key='cat.id'>
         <Cat :cat='cat' :action='() => {}'/>
         <div id='progressbar'>
            <progress :value='cat.score' min='0' max='100'></progress>
          </div>
      </div>
    </ul>
  </div>
</template>

<script>
import axios from 'axios';
import Cat from '@/components/Cat';

export default {
  name: 'catGrid',
  components: {
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
</style>
