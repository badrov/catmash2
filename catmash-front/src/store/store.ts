import Vue from 'vue';
import Vuex from 'vuex';
import Axios from 'axios';

Vue.use(Vuex);

export default new Vuex.Store({
  state: {
    cats: [],
    randomCats : [],
  },
  getters : {
    CATS : (state) => {
      return state.cats;
    },
    RANDOM_CATS : (state) => {
      return state.randomCats;
    },
  },
  mutations: {
    setCats(state, data) {
      state.cats = data;
    },
    setRandomCats(state, data) {
      state.randomCats = data;
    },
  },
  actions: {
    async getCats(context) {
      const data = (await Axios.get('http://localhost:8080/cats')).data;
      context.commit('setCats', data);
    },
    async getRandomCats(context, count) {
      const data =  (await Axios.get( 'http://localhost:8080/cats/random?count=' + count)).data;
      context.commit('setRandomCats', data);
    },
    async updateCat(context, catId) {
      const data =  (await Axios.put( 'http://localhost:8080/cat/' + catId)).data;
    },
  },

});
