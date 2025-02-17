const Item = require('../model/item')
const mongoose = require('mongoose');

module.exports = class ItemController{

    static async createItem(req, res){
        const {name, amount} = req.body

        if(!name){
            res.status(422).json({message: 'O nome é obrigatorio!'})
            return
        }

        if(!amount){
            res.status(422).json({message: 'A quantidade é obrigatorio!'})
            return
        }

        const item = new Item({
            name: name,
            amount: amount,
        })

        try {
            
            const newItem = await item.save()
            res.status(202).json({message: 'Item criado com sucesso', newItem})

        } catch (error) {
            res.status(500).json({message: error})
        }
    }

    static async modifyItem(req, res){

        const id = req.params.id
        let item

        try {
            item = await Item.findbyId(id)
        } catch (error) {
            res.status(500).json({message: error})
        }

        const amount = req.body

        item.amount = amount
        console.log(item)

        try {
            await Item.findByIdAndUpdate(id, item)
        } catch (error) {
            res.status(500).json({message: error})
        }
    }

    static async allItens(req, res){

        const itens = await Item.find().sort('-createdAt')

        res.status(200).json({itens: itens,})
    }
}