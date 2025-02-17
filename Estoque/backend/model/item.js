const mongoose = require('mongoose')
const { Schema } = mongoose

const Item = mongoose.model(
    'Item',
    new Schema({
        name: {
            type: String,
            required: true
        },
        amount: {
            type: Number,
            required: true
        },
    },
    {timestamps: true},
    ),
)

module.exports = Item