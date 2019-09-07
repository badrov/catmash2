<template>
  <div class="cat">
    <br>
    <img id='img1' class='img usemap=#m1' :src='cat.url' v-on:click='action(cat)'/>
    <a href=# class=close></a>
    <img class=expand src=http://icons.iconarchive.com/icons/icons8/ios7/16/Editing-Expand-icon.png/>
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
  width: 500px;
  height: 200px;
}
.cat {
  display: inline-block;
  margin: 0 10px;
}
a {
  color: #42b983;
}

.img {
  border-radius: 2px;
  box-shadow: 0 0 5px #343436;
  filter:brightness(1.1);
  border-radius: 10%;
  box-sizing: border-box;
  max-width: 100%;
  background-size: cover;
  border: 5px solid #b77b7b;
}

.close {
  background-image: url(https://bit.ly/29QeT21);
  background-repeat: no-repeat;
  bottom: 418px;
  display: none;
  height: 32px;
  left: 462px;
  margin-top: -32px;
  position: relative;
  width: 32px;
}
.expand{
  bottom: 125px;
  margin-left: -32px;
  margin-right: 16px;
  pointer-events: none;
  position: relative;
}
#wrapper {
  margin: auto;
  padding: 10px;
  text-align: center;
  width: 500px;
}
body{
  background-image: linear-gradient(to bottom, #178FDD  68px,  antiquewhite 68px  );
  height: 1000px;
}
h2{
  color: #000;
  font-family: bungee shade, georgia;
  text-align: center;
  text-shadow: 0 0 2px #343436;
}

</style>
