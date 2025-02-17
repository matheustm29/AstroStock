const express = require('express')
const cors = require('cors')
const mongoose = require('mongoose')

const app = express()

const port = process.env.PORT || 5001

app.use(express.json())

app.use(cors())

//Routes
const Itemroutes = require('./routes/itemroutes')

app.use('/item', Itemroutes)



mongoose
    .connect('mongodb+srv://thomas:123456789thomas@cluster0.2ghui.mongodb.net/?retryWrites=true&w=majority&appName=Cluster0')
    .then(() => {
        console.log("Conectamos ao banco")
        app.listen(5000)
    })
    .catch((err) => console.log(err))