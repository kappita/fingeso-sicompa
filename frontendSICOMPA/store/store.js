import { reactive, ref } from "vue";


export const store = reactive({
  username: null,
  email: null,
  password: null,
  quota: null,
  community_quota: null,
  usage_percentage: null,
  community_id: null
})