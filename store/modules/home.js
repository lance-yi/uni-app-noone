import { CHANGE_HOME_DATA, STORE_ID_LIST } from './../mutations_type'
import API from '@/utils/http/'

const state = {
  ids: [],
  data: {
    hp_content: '',
    hp_img_url: '',
    hp_author: '',
    text_authors: ''
  }
}

const mutations = {
  [CHANGE_HOME_DATA](state, payload) {
    state.data = payload.result
  },
  [STORE_ID_LIST](state, payload) {
    state.ids = payload.ids
  },
}

const actions = {
	async getTest({ commit }) {
		const { data } = await API.test();
		commit(CHANGE_HOME_DATA, { data })
	},
  async getNewIds({ commit }) {
    const { data } = await API.getNewIds()
    commit(STORE_ID_LIST, { ids: data })
  },
	
  async getWxArtList({ commit, state }) {
    const { data }  = await API.getWxArtList({
			page: 1,
			pageSzie: 20
		})
		let result = {}
		if(data.error_code === 0){
			console.log(JSON.parse(data.result))
			result = JSON.parse(data.result)
		}
    commit(CHANGE_HOME_DATA, { result })
  }
}

export default {
  state,
  mutations,
  actions
}
