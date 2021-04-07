import {
  axios
} from '@/utils/request'
import api from './index'

export function getEntertainment(parameter) {
  return axios({
    url: api.getEntertainment,
    method: 'post',
    params: parameter
  })
}
export function getHospital(parameter) {
  return axios({
    url: api.getHospital,
    method: 'post',
    params: parameter
  })
}
export function getHotel(parameter) {
  return axios({
    url: api.getHotel,
    method: 'post',
    params: parameter
  })
}
export function getRestaurant(parameter) {
  return axios({
    url: api.getRestaurant,
    method: 'post',
    params: parameter
  })
}
export function getAttraction(parameter) {
  return axios({
    url: api.getAttraction,
    method: 'post',
    params: parameter
  })
}

export function getTrain(parameter) {
  return axios({
    url: api.getTrain,
    method: 'post',
    data: parameter
  })
}


export function test(params) {
  console.log('test export')
}