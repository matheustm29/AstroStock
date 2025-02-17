import React, { useEffect, useState } from "react";
import api from "../utils/api";

const Home = () => {
  const [itens, setItens] = useState([]);
  const [filteredItens, setFilteredItens] = useState([]);
  const [search, setSearch] = useState("");
  const [modalOpen, setModalOpen] = useState(false);
  const [newItem, setNewItem] = useState({ name: "", amount: "" });

  useEffect(() => {
    const testData = [
      { id: 1, name: "Parafuso", amount: 5 },
      { id: 2, name: "Barra de ferro", amount: 3 },
      { id: 3, name: "Cabo de aco", amount: 2 }
    ];
  
    setItens(testData);
    setFilteredItens(testData);
  }, []);
  
  
  

  const handleSearch = (e) => {
    const value = e.target.value;
    setSearch(value);
    setFilteredItens(
      itens.filter((item) => item.name.toLowerCase().includes(value.toLowerCase()))
    );
  };

  const handleEdit = (id) => {
    const amount = prompt("Digite a nova quantidade:");
    if (amount) {
      setItens(
        itens.map((item) => (item.id === id ? { ...item, amount } : item))
      );
    }
  };

  const handleRegister = () => {
    api.post("/item/register", newItem).then((response) => {
      setItens([...itens, response.data]);
      setFilteredItens([...itens, response.data]);
      setModalOpen(false);
      setNewItem({ name: "", amount: "" });
    });
  };

  return (
    <div className="estoque-container">
      <input
        placeholder="Buscar item..."
        value={search}
        onChange={handleSearch}
        className="search-bar"
      />
      <div className="items-list">
  {filteredItens.map((item) => (
    <div key={item.id} className="item-card">
      <span>{item.name} - {item.amount}</span>
      <button className="edit-button" onClick={() => handleEdit(item.id)}>Editar</button>
    </div>
  ))}
</div>

      {/* Botão de Cadastro */}
      <button className="register-button" onClick={() => setModalOpen(true)}>Cadastrar Item</button>

      {/* Modal de Cadastro */}
      {modalOpen && (
        <div className="modal-overlay">
          <div className="modal-content">
            <h2>Cadastrar Novo Item</h2>
            <input
              placeholder="Nome"
              value={newItem.name}
              onChange={(e) => setNewItem({ ...newItem, name: e.target.value })}
              className="input-field"
            />
            <input
              placeholder="Quantidade"
              type="number"
              value={newItem.amount}
              onChange={(e) => setNewItem({ ...newItem, amount: e.target.value })}
              className="input-field"
            />
            <button className="save-button" onClick={handleRegister}>Salvar</button>
            <button className="close-button" onClick={() => setModalOpen(false)}>Fechar</button>
          </div>
        </div>
      )}

      <style jsx>{`
        .estoque-container {
          background: linear-gradient(135deg, #1a1a2e, #16213e);
          color: #ffffff;
          padding: 20px;
          min-height: 100vh;
          font-family: 'Arial', sans-serif;
          text-align: center;
        }
        .search-bar {
          width: 100%;
          padding: 10px;
          border-radius: 5px;
          background: #0f3460;
          color: white;
          border: none;
          margin-bottom: 20px;
        }
        .items-list {
          display: flex;
          flex-direction: column;
          align-items: center;
        }
        .item-card {
          display: flex;
          justify-content: space-between;
          width: 80%;
          background: #0f3460;
          padding: 10px;
          border-radius: 5px;
          margin-bottom: 10px;
        }
        .edit-button {
          background: #f4a261;
          color: white;
          padding: 5px 10px;
          border-radius: 5px;
          border: none;
          cursor: pointer;
        }
        .register-button {
          background: #e94560;
          color: white;
          padding: 10px 20px;
          border-radius: 5px;
          border: none;
          margin-top: 20px;
          cursor: pointer;
        }
        .modal-overlay {
          position: fixed;
          top: 0;
          left: 0;
          width: 100%;
          height: 100%;
          background: rgba(0, 0, 0, 0.7);
          display: flex;
          justify-content: center;
          align-items: center;
        }
        .modal-content {
          background: #16213e;
          padding: 20px;
          border-radius: 10px;
          width: 300px;
          text-align: center;
        }
        .input-field {
          width: 90%;
          padding: 10px;
          border-radius: 5px;
          margin: 10px 0;
          border: none;
          background: #0f3460;
          color: white;
        }
        .save-button {
          background: #2ecc71;
          color: white;
          padding: 10px;
          border-radius: 5px;
          border: none;
          cursor: pointer;
        }
        .close-button {
          background: #e74c3c;
          color: white;
          padding: 10px;
          border-radius: 5px;
          border: none;
          margin-left: 10px;
          cursor: pointer;
        }
      `}</style>
    </div>
  );
};

export default Home;
