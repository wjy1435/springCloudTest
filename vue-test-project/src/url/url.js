import * as axios from 'axios'

let instance = axios.create({
    baseURL: 'http://192.168.1.8:8084',
    headers: {
        // "accept": "application/json",
        'Content-Type': 'application/json',
    }
});

//user
export const userLogin = obj => {
    return instance.post('/loginPages', obj).then(res => res.data)
}
export const userPages = obj => {
    return instance.post('/pageHelper', obj).then(res => res.data)
}


