<template id='Comparison'>
  <div id="cat-grid">
      <photo-grid
          :box-height="'400px'"
          :box-width="'30%'"
          :excess-text="'+ {{cats.length}} images in gallery'"
          @clickExcess="triggerClick"
          <img v-for="cat in cats"
              :src="cat.url"
          />
      ></photo-grid>
  </div>
</template>

<script>
import axios from 'axios';
export default {
  name: 'Comparison',
  data() {
    return {
      msg: 'Cat\'s score',
      cats: null,
    };
  },
  mounted() {
     axios({ method: 'GET', url: 'http://localhost:8080/cats' })
     .then( (result) => this.cats = result.data);
  },
  methods: { },
};
</script>
