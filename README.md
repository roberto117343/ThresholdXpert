Claro, aquí tienes el archivo README.md completo y listo para copiar y pegar, en formato Markdown.

code
Markdown
download
content_copy
expand_less

# ThresholdXpert 1.0

A Java-based software tool and methodology for the **determination and optimization of diagnostic cut-off points** for individual biomarkers and **multimarker panels**.

<p align="center">
  <img src="https://raw.githubusercontent.com/roberto117343/ThresholdXpert/main/ThresholdXpert/src/main/java/com/RRF/ThresholdXpert/logo/Logo%20ThresholdXpert.png" 
       alt="ThresholdXpert Logo" width="200"/>
</p>

<p align="center">
  <img src="https://img.shields.io/badge/License-GPLv3-blue.svg" alt="License: GPL v3"/>
  <img src="https://img.shields.io/badge/Java-11+-orange.svg" alt="Java Version"/>
  <img src="https://img.shields.io/badge/Python-3.x-yellow.svg" alt="Python Scripts"/>
  <img src="https://img.shields.io/badge/Platform-Cross--Platform-lightgrey.svg" alt="Platform"/>
</p>

<p align="center">
  <a href="https://github.com/roberto117343/ThresholdXpert/raw/main/ThresholdXpert/target/ThresholdXpert-1.0.jar" style="text-decoration:none;">
    <img src="https://img.shields.io/badge/Download-ThresholdXpert--1.0.jar-brightgreen?style=for-the-badge&logo=github" alt="Download .jar"/>
  </a>
</p>

---

## 💡 What is ThresholdXpert?

ThresholdXpert is a user-friendly desktop application designed to tackle a fundamental challenge in clinical diagnostics: finding optimal cut-off points for quantitative biomarkers. It implements a **two-stage methodology** that combines rigorous mathematical modeling for individual markers with a powerful, user-guided combinatorial optimization for multimarker panels.

This project was developed and applied to the problem of risk stratification in pulmonary nodules, demonstrating its ability to identify simple, robust, and high-performance diagnostic panels.

---

## 🎯 The Problem

Determining the best cut-off points for diagnostic tests is complex. Conventional methods like ROC analysis may not always yield a clinically useful balance between **sensitivity** and **specificity**. The challenge intensifies when combining multiple markers into a panel, where simple logical rules (like "OR" or "AND") often lead to poor performance, and complex "black-box" models lack interpretability.

There is a need for a systematic, transparent, and effective tool to derive and optimize diagnostic thresholds, both for single markers and for complex panels.

---

## 🔬 Our Solution: A Two-Stage Methodology

ThresholdXpert introduces a structured, two-stage approach to solve this problem.

### **Stage 1: Individual Marker Analysis (with Python Scripts)**
The first stage focuses on deeply understanding each biomarker individually. Using the provided Python scripts, you can:
1.  **Generate Empirical Profiles**: Calculate and visualize how sensitivity and specificity change across all possible cut-off points for a marker.
2.  **Perform Logistic Fitting**: Model these empirical profiles by fitting logistic functions, creating smooth, analytical curves.
3.  **Determine Optimal Cut-offs**: Analytically calculate a balanced cut-off (where Sens = Spec) or determine the specific cut-off needed to achieve a predefined performance target (e.g., 90% sensitivity).

### **Stage 2: Combinatorial Panel Optimization (with the Java GUI)**
The second stage uses the `ThresholdXpert 1.0` graphical tool to optimize the thresholds of multiple markers **simultaneously**. This is the core of the tool, allowing you to:
1.  **Define a Panel**: Select the variables to include in your diagnostic panel.
2.  **Set Performance Goals**: Specify your desired targets for sensitivity, specificity, and overall accuracy.
3.  **Optimize**: The tool iteratively searches for the best combination of thresholds for your panel that meets your goals, using a simple and interpretable "OR" classification rule. The search is accelerated using multithreading.

---

## ✨ Key Features of the GUI

<p align="center">
  <img src="https://raw.githubusercontent.com/roberto117343/ThresholdXpert/main/img/GUI_example.png" alt="ThresholdXpert GUI" width="500"/>
  <br><em>Figure: Parameter configuration in ThresholdXpert 1.0.</em>
</p>

1.  **Combinatorial Threshold Optimization (`Calculate Thresholds`)**
    -   Optimizes cut-offs for **multimarker panels** to meet user-defined performance targets (e.g., `0.8;0.8;0.8` for Sens;Spec;Accuracy).
    -   Allows the user to restrict the **search space** for each variable's threshold, speeding up optimization.
    -   Leverages **multithreading** (up to 8 threads) to accelerate the search for solutions.

2.  **Batch Prediction (`File prediction`)**
    -   Applies a predefined set of thresholds to an entire CSV dataset.
    -   Outputs a new CSV file with the predicted classification for each case, allowing for external validation.

3.  **Single Case Prediction (`Individual prediction`)**
    -   Manually enter the biomarker values for a single case (e.g., one patient).
    -   The tool instantly reports the classification (**positive/negative**) based on the currently defined thresholds.

---

## 📦 Installation & Usage

### Requirements
*   **ThresholdXpert App**: Java Runtime Environment (JRE 11 or higher).
*   **Supporting Scripts (Optional)**: Python 3.x with the `matplotlib` library.

### Using the App (ThresholdXpert-1.0.jar)
No installation is needed. Run the application from your terminal:
```bash
java -jar ThresholdXpert-1.0.jar
```
**Workflow:**
1.  **Load Input File**: Click `Input` to load a CSV file. The file should have markers in columns and the true class in the final column.
    -   **Format**: Semicolon-separated values (`;`). The last column must be the class (`1` for positive, `0` for negative). Decimals use a period (`.`).
2.  **Select Calculation Type**: Choose one of the three main functions from the dropdown menu.
3.  **Set Parameters (for `Calculate Thresholds`)**:
    -   *Search values*: Target sensitivity, specificity, and total accuracy (e.g., `0.8;0.85;0.8`).
    -   *Maximum values*: The upper search limit for each marker's threshold, separated by semicolons.
    -   *Threads*: Number of parallel threads to use for optimization (1-8).
4.  **Run**: Click `Calculate`. The tool will display candidate threshold combinations in real-time.

### Using the Supporting Python Scripts
The scripts are located in the `/Scripts` directory. They are designed for Stage 1 of the methodology.
```bash
# Example for generating an empirical profile
python Scripts/S3.1.py
```
-   **Input Format**: A text or CSV file where each line is `value;class`.

---

## 📜 How to Cite

If you use ThresholdXpert 1.0 or its methodology in your research, please cite the accompanying paper:

> Reinosa Fernández, R. (2023). *Determinación y Optimización de Puntos de Corte Diagnósticos para Paneles Multimarcador mediante un Enfoque de Dos Etapas y la Herramienta de Software ThresholdXpert 1.0: Aplicación a la Estratificación de Riesgo de Nódulos Pulmonares*. [Manuscript/Preprint].

---

## 📄 License

This project is licensed under the **GNU General Public License v3.0**. See the [LICENSE](LICENSE) file for details.

---

## 📬 Contact

**Roberto Reinosa Fernández**
-   📧 [roberto117343@gmail.com](mailto:roberto117343@gmail.com)
-   💻 [GitHub Profile](https://github.com/roberto117343)
