<template>

<div>
  <v-container>
    
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

<style scoped>

</style>
