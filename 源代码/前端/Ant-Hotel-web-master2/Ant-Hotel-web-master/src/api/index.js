const api = {
  Login: '/auth/login',
  Logout: '/auth/logout',
  ForgePassword: '/auth/forge-password',
  Register: '/auth/register',
  twoStepCode: '/auth/2step-code',
  SendSms: '/account/sms',
  SendSmsErr: '/account/sms_err',
  // get my info
  getAttraction: '/Attraction/QueryAttractionByRecommends',
  getEntertainment: '/Entertainment/queryEntertainmentListByRecommands',
  getHospital: '/Hospital/QueryHospitalListByReCommands',
  getHotel: '/Hotel/queryHotelByRecommends',
  getRestaurant: '/Restaurant/QueryRestaurantListByRecommends',
  getTrain: '/Train/QueryTrainByRecommand',
}
export default api