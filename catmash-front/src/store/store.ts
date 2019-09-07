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
      const data = (await Axios.get('http://localhost:8080/api', {
        params: {
          query: '{getCats{id, url, score}}',
        },
      })).data;
      context.commit('setCats', data.data.getCats);
    },

    async getRandomCats(context, count) {
      const data = (await Axios.get('http://localhost:8080/api', {
        params: {
          query: '{getRandomCats(count: 2){id, url}}',
        },
      })).data;
      context.commit('setRandomCats', data.data.getRandomCats);
    },

    async updateCat(context, catId) {
      (await Axios.post('http://localhost:8080/api', {
        query: `mutation { updateCatScore(id: ${ JSON.stringify(catId) }){ id } }`,
      }));
    },
  },

});
