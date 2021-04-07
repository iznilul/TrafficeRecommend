<template>
  <div>
  <div class="mb-10">
    <label>省份<input v-model="province"/></label>

    <label>城市<input v-model="city"/></label>

    <label>地区<input v-model="area"/></label>

    <label>数量<input v-model="size"/></label>

    <button @click="getData()">查询</button>
</div>

  <baidu-map class="map" ak="2ScuT42mtQVhOOMdUfwHlZQDUV2G7r68" :center="center" :zoom="zoom" @ready="handler" :scroll-wheel-zoom="true">
    <bm-navigation anchor="BMAP_ANCHOR_TOP_RIGHT"></bm-navigation>
    <bm-overview-map anchor="BMAP_ANCHOR_BOTTOM_RIGHT" :isOpen="true"></bm-overview-map>
    <bm-point-collection :points="points" shape="BMAP_POINT_SHAPE_RHOMBUS" color="red" size="BMAP_POINT_SIZE_BIG" @click="clickHandler"></bm-point-collection>
  </baidu-map>
  </div>
</template>

<script>
import BaiduMap from 'vue-baidu-map/components/map/Map'
import {BmlMarkerClusterer} from 'vue-baidu-map'
import {BmOverviewMap} from 'vue-baidu-map'
import {BmNavigation} from 'vue-baidu-map'
import {BmPointCollection} from  'vue-baidu-map'
import {BmControl} from  'vue-baidu-map'
import {getAttraction} from '../../api/manage'
export default {
  components: {
    BaiduMap,
      BmlMarkerClusterer,
      BmOverviewMap,
      BmNavigation,
      BmPointCollection,
      BmControl
  },
    data () {
        return {
            center: {lng: 0, lat: 0},
            zoom: 10,
            attractions:[],
            points: [],
            province:'',
            city:'',
            area:'',
            size:1
        }
    },
    created(){
      this.handler(116.404,39.915)
    },
    methods: {
        clickHandler (e) {
            alert(`名称:${e.point.name}\n地点:${e.point.province},${e.point.city},${e.point.area}\n地址:${e.point.address}\n坐标:${e.point.lng}, ${e.point.lat}\n推荐值:${e.point.recommend}`)
        },
        handler (lng,lat) {
            console.log(lng, lat)
            this.center.lng = lng
            this.center.lat = lat
            this.zoom = 10
        },
        getData(){
            getAttraction({ScenicAreaProvince:this.province,ScenicAreaCity:this.city,ScenicAreaArea:this.area,Size:this.size}).then(res=>{
                console.log(res.data)
                this.attractions=res.data
                // console.log(typeof Number(this.attractions[0].locationLng))
                this.handler(Number(this.attractions[0].locationLng),Number(this.attractions[0].locationLat))
                this.addPoints()
            })
        },
        addPoints () {
            const s=[]
            for (var i = 0; i <this.attractions.length; i++) {
                const position = {lng: Number(this.attractions[i].locationLng),
                    lat: Number(this.attractions[i].locationLat),
                    province:this.attractions[i].province,
                    city:this.attractions[i].city,
                    area:this.attractions[i].area,
                    address:this.attractions[i].address,
                    name:this.attractions[i].name,
                    recommend:this.attractions[i].recommends}
                s.push(position)
            }
            this.points=s
            // console.log(this.points)
            // return s
        },
    },
//     watch:{
//       attractions(val){
//           this.points=this.addPoints()
// }
//     }
}
</script>

<style scoped>
  .map {
    width: 100%;
    height: 600px;
  }
</style>
