import React from 'react';


export default function Navbar() {
  return (
    <nav style={styles.navbar}>
      <ul style={styles.navList}>
        <li style={styles.navItem}>
          <a href="#estoque" style={styles.navLink}>Estoque</a>
        </li>
        <li style={styles.navItem}>
          <a href="#foguetes" style={styles.navLink}>Foguetes</a>
        </li>
        <li style={styles.navItem}>
          <a href="#tarefas" style={styles.navLink}>Tarefas</a>
        </li>
      </ul>
    </nav>
  );
}


const styles = {
  navbar: {
    backgroundColor: "#1a1a1a",
    padding: "15px 0",
    position: "fixed",
    top: 0,
    width: "100%",
    zIndex: 1000,
    boxShadow: "0 4px 10px rgba(0, 0, 0, 0.3)",
    marginbottom: "100%"
  },
  navList: {
    display: "flex",
    justifyContent: "center",
    listStyleType: "none",
    margin: 0,
    padding: 0,
  },
  navItem: {
    margin: "0 20px",
  },
  navLink: {
    color: "white",
    fontSize: "18px",
    textDecoration: "none",
    padding: "10px 15px",
    borderRadius: "5px",
    transition: "background-color 0.3s ease",
  },
  navLinkHover: {
    backgroundColor: "#4a90e2",
  },
};
