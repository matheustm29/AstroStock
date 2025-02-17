const router = require('express').Router()
const ItemController = require('../controllers/itemcontroller')

router.post('/register', ItemController.createItem)
router.get('/allitens', ItemController.allItens)
router.patch('/modify/:id', ItemController.modifyItem)

module.exports = router