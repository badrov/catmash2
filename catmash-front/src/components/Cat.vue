<template>
  <div class="cat">
    <br>
    <img :src='cat.url' v-on:click='action(cat)'>
  </div>
</template>

<script>
export default {
  name: 'Cat',
  props: {
    cat: Object,
    action: Function,
  },
  data() {
    return {
    };
  },
};
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
h1, h2 {
  font-weight: normal;
}
.cat {
  list-style-type: none;
  padding: 0;
}
.cat {
  display: inline-block;
  margin: 0 10px;
}
a {
  color: #42b983;
}
img {
    max-width: 100%;
    height: 200px;
}
</style>
