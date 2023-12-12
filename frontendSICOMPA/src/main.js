//import './assets/main.css'

import { createApp } from 'vue'
import App from './App.vue'



//import 'bootstrap-vue/dist/bootstrap-vue.css'

import './assets/bootstrap.min.css'
import './assets/bootstrap.bundle.min.js/'

const app = createApp(App)

app.use(createPinia())

app.mount('#app')




/* import './assets/main.css'

import { createApp } from 'vue'
import { createPinia } from 'pinia'
import App from './App.vue'
import {BootstrapVue, IconsPlugin} from 'bootstrap-vue';
//import axios, {isCancel, AxiosError} from 'axios';
import axios from 'axios';

Vue.use(BootstrapVue)
Vue.use(IconsPlugin)
Vue.use(axios)
//Vue.use(isCancel)
//Vue.use(AxiosError)

import 'bootstrap/dist/css/bootstrap.css';
import 'bootstrap-vue/dist/bootstrap-vue.css';

const app = createApp(App)

app.use(createPinia())

app.mount('#app') */
