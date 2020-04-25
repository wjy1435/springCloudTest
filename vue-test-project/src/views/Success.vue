<template>
    <el-table
            :data="tableData"
            style="width: 100%">
        <el-table-column
                prop="id"
                label="日期"
                width="180">
        </el-table-column>
        <el-table-column
                prop="name"
                label="姓名"
                width="180">
        </el-table-column>
        <el-table-column
                prop="password"
                label="地址">
        </el-table-column>
    </el-table>
</template>

<script>
    import * as api from '../url/url'
    export default {

        mounted:function(){
            this.getUserList();
        },
        methods:{
            getUserList:function () {
                api.userPages().then(res =>{
                    if(res){
                        console.log(res)
                        if(res.status == 200){
                           this.tableData = res.data
                        }else{
                            alert("用户名或密码错误！！！"+{type:"error"});
                        }
                    }
                }).catch(function (error) {
                    alert(error.toString()+{type:"error"}+"888");
                })
            }
        },
        data() {
            return {
                tableData: []
            }
        }
    }
</script>

<style scoped>

</style>