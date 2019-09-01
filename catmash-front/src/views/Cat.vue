<template>
  <div class="cats">
    <h1>This is an cats page</h1>
    <br>
    <img :src='cat.info.url' v-on:click='action(cat)'>
  </div>
</template>


