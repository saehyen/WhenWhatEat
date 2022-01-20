<template>

<div>
  <v-container>
    <table class="table">
      <thead>
        <tr> 
          <th scope="col" style="width:20%;">게시글 번호</th> 
          <th scope="col" style="width:40%;">제목</th>
          <th scope="col" style="width:20%;">작성일</th>
          <th scope="col" style="width:20%;">조회수</th>     
        </tr>
      </thead>
      <tbody>
        <tr v-for="data in data.content" :key="data.noticeIdx" id="board_tr">
          <td scope="row">{{data.noticeIdx}}</td>
          <td><a v-on:click="view(data)" id="board_title">{{data.title}}</a></td>
          <td scope="row">{{data.registDate}}</td>
          <td scope="row">{{data.views}}</td>
        </tr>
      </tbody>
    </table>

    <v-row d-flex align="center"
      justify="center">
      <v-col align="center"
      justify="center">
        <router-link 
        class="button" 
        to="/create"
        >작성하기</router-link>
      </v-col>
    </v-row>
    <v-row>
      <div class="">
          <v-pagination 
            v-model="data.currentPage"
            :length="data.totalPages"
            @input="handlePageChange"
          ></v-pagination>    
      </div>
    </v-row>
  </v-container>
  </div>
</template>

<script>
import $ from 'jquery' 
import axios from 'axios'
export default {
  

  data(){
    return{
      data: [], 
      page: 1

    }
  },
  methods:{
   
    view(data){
      console.log(data)
      this.$router.push({
        name:"detail",
        query :{body: data.content,
                id: data.noticeIdx,
                title: data.title,
                views: data.views,
                content: data.content}
      })
    },
    handlePageChange(pageNo) {
      this.page = pageNo;
      console.log(this.page)
    axios({
        url: "http://ec2-13-124-134-65.ap-northeast-2.compute.amazonaws.com:8080/api/noticelist?page=" + (pageNo-1),
        type : "get",
      })
    .then((response) =>{
        this.data = response.data;
        console.log(this.data)

        var list= '';
        for(let i = 0; i < this.data.numberOfElements; i++){
          list += "<tr>"
          list +=   "<td>" + this.data.content[i].notIdx + "</td>"     
          list +=   "<td><a href='notice?notIdx=" + this.data.content[i].notIdx + "'>" + this.data.content[i].notTitle + "</a></td>"    
          list +=   "<td>" + this.content[i].writer + "</td>"    
          list +=   "<td>" + this.content[i].registDate + "</td>"    
          list +=   "<tr>"    
          }
          $("tbody").empty();
          $("tbody").append(list);
    })
    },
  
    create(){
      console.log('hi')
      this.$router.push({
        name:"create"
      })
    },
    getItem(){
      const page = 0;

        axios.get("http://ec2-13-124-134-65.ap-northeast-2.compute.amazonaws.com:8080/api/noticelist?page=" + page)
        .then((response) => {
            this.data = response.data;  
            console.log(this.data)
            console.log( this.data.totalPages)
            console.log(this.data.totalElements)
            console.log(this.data.size)
            console.log(this.data.numberOfElements)
            console.log(this.data.content)
          var pageBtn  = '';
          
          for(var pageNo = 0; pageNo < this.data.totalPages; pageNo++){ 
              pageBtn += "<li>";
              pageBtn += "<button id=\"btn_write\" class=\"btn_write btn btn-primary btn-floating\" v-on:click=\"page("+ (pageNo+1) +")\">" +(pageNo+1)+"</button>";
              pageBtn += "</li>";

          }
          console.log(pageBtn)
          $("ul#pages").append(pageBtn)
        
 
        })
    },
/*    page(pageNo){
      console.log('hi')
      axios({
        url: "http://localhost:8080/api/noticelist?page=" + (pageNo-1),
        type : "get",
      
      })
      .then((response) =>{
        this.data = response.data;
        console.log("thisis "+this.data)
      
        var list= '';
        for(let i = 0; i < this.data.numberOfElements; i++){
          list += "<tr>"
          list +=   "<td>" + this.data.content[i].notIdx + "</td>"     
          list +=   "<td><a href='notice?notIdx=" + this.data.content[i].notIdx + "'>" + this.data.content[i].notTitle + "</a></td>"    
          list +=   "<td>" + this.content[i].writer + "</td>"    
          list +=   "<td>" + this.content[i].regDate + "</td>"    
          list +=   "<tr>"    
          }
          $("tbody").empty();
          $("tbody").append(list);
    })
  },  */
  
    
  },
  
  created(){
    this.getItem();
  }
  

}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
h3 {
  margin: 40px 0 0;
}
ul {
  list-style-type: none;
  padding: 0;
}
li {
  display: inline-block;
  margin: 0 10px;
}
a {
  color: #42b983;

}
.pagination-wrapper{
   display:flex;
}
.pageBtn{
   display: flex;
    align-content: stretch;
    padding: 10px;
    justify-content: center;
}
.table {
  width:100%;
  text-align: center;
  color:white;
  font-size:1.3rem;
}
.table a{
  font-size:1.3rem;
}
table tbody tr{
  height:35px;
}
#board_tr{
  height:80px;
  vertical-align: middle;
}
#board_title{
  cursor:pointer;
}
/* button 스타일링 */
a {
   -webkit-transition: all 200ms cubic-bezier(0.390, 0.500, 0.150, 1.360);
   -moz-transition: all 200ms cubic-bezier(0.390, 0.500, 0.150, 1.360);
   -ms-transition: all 200ms cubic-bezier(0.390, 0.500, 0.150, 1.360);
   -o-transition: all 200ms cubic-bezier(0.390, 0.500, 0.150, 1.360);
   transition: all 200ms cubic-bezier(0.390, 0.500, 0.150, 1.360);

   margin: 0 auto;
   max-width: 100px;
  height:40px;
  line-height:30px;
   text-decoration: none;
   border-radius: 4px;
   padding: 5px;
  font-size:14px;
  font-weight:600;
  text-align: center;
}

a.button {
   color: rgba(30, 22, 54, 0.6);
   box-shadow: rgba(30, 22, 54, 0.4) 0 0px 0px 2px inset;
  background-color:white;
}

a.button:hover {
   color: rgba(255, 255, 255, 0.85);
   box-shadow: rgba(30, 22, 54, 0.7) 0 0px 0px 40px inset;
}

</style>