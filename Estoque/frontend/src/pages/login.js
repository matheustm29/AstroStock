import React, { useState } from "react";

export default function LoginEspacial() {
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");

  const entrar = () => {
    const dadosLogin = { email, password };
    console.log("Enviando para a API:", dadosLogin);
  };

  return (
    <div style={styles.body}>
      {}
      {[...Array(10)].map((_, i) => (
        <div
          key={i}
          style={{
            ...styles.star,
            ...styles[`star${i + 1}`],
            animation: `twinkle ${Math.random() * 2 + 1}s infinite alternate`,
          }}
        ></div>
      ))}

      <div style={styles.container}>
        <div style={styles.loginBox}>
          <div style={styles.rocketIcon}>🚀</div>
          <h2 style={styles.title}>Login Espacial</h2>
          <p style={styles.subtitle}>Acesse o universo do projeto Rockets</p>
          <div style={styles.inputContainer}>
            <input
              type="email"
              placeholder="Seu e-mail"
              style={styles.input}
              value={email}
              onChange={(e) => setEmail(e.target.value)}
            />
            <input
              type="password"
              placeholder="Sua senha"
              style={styles.input}
              value={password}
              onChange={(e) => setPassword(e.target.value)}
            />
            <button style={styles.button} onClick={entrar}>
              Entrar
            </button>
          </div>
        </div>
      </div>

      {}
      <style>
        {`
          @keyframes twinkle {
            0% { opacity: 0.2; transform: scale(1); }
            50% { opacity: 1; transform: scale(1.2); }
            100% { opacity: 0.2; transform: scale(1); }
          }
        `}
      </style>
    </div>
  );
}


const styles = {
  body: {
    fontFamily: "Arial, sans-serif",
    backgroundColor: "black",
    color: "white",
    display: "flex",
    alignItems: "center",
    justifyContent: "center",
    height: "100vh",
    margin: 0,
    overflow: "hidden",
    position: "relative",
  },
  container: {
    display: "flex",
    justifyContent: "center",
    alignItems: "center",
    height: "100%",
  },
  loginBox: {
    backgroundColor: "#1a1a1a",
    padding: "50px",
    borderRadius: "16px",
    boxShadow: "0 4px 10px rgba(0,0,0,0.3)",
    border: "1px solid #444",
    width: "500px",
    textAlign: "center",
    zIndex: 2,
    position: "relative",
  },
  rocketIcon: {
    fontSize: "60px",
    color: "#4a90e2",
    animation: "pulse 1.5s infinite",
  },
  title: {
    fontSize: "28px",
    fontWeight: "bold",
    marginTop: "16px",
  },
  subtitle: {
    color: "#ccc",
    fontSize: "16px",
    marginBottom: "24px",
  },
  inputContainer: {
    width: "100%",
    marginTop: "16px",
  },
  input: {
    width: "100%",
    padding: "12px",
    marginBottom: "12px",
    backgroundColor: "#333",
    border: "1px solid #555",
    color: "white",
    borderRadius: "4px",
  },
  button: {
    width: "100%",
    padding: "12px",
    backgroundColor: "#4a90e2",
    border: "none",
    color: "white",
    fontSize: "18px",
    borderRadius: "4px",
    cursor: "pointer",
  },
  star: {
    position: "absolute",
    width: "5px",
    height: "5px",
    backgroundColor: "white",
    borderRadius: "50%",
  },
  
  star1: { top: "10%", left: "20%" },
  star2: { top: "30%", left: "50%" },
  star3: { top: "60%", left: "80%" },
  star4: { top: "80%", left: "30%" },
  star5: { top: "20%", left: "70%" },
  star6: { top: "50%", left: "10%" },
  star7: { top: "40%", left: "90%" },
  star8: { top: "90%", left: "60%" },
  star9: { top: "15%", left: "40%" },
  star10: { top: "70%", left: "20%" },
};
