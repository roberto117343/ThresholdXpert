# ThresholdXpert 1.0

Software tool for the **determination and optimization of diagnostic thresholds** in individual biomarkers and **multimarker panels**.

<p align="center">
  <img src="https://raw.githubusercontent.com/roberto117343/ThresholdXpert/main/Logo/ThresholdXpertLogo.png" 
       alt="ThresholdXpert Logo" width="200"/>
</p>

<p align="center"><em>Official logo of ThresholdXpert 1.0</em></p>

<p align="center">
  <img src="https://img.shields.io/badge/License-GPLv3-blue.svg" alt="License: GPL v3"/>
  <img src="https://img.shields.io/badge/Java-11-orange.svg" alt="Java Version"/>
  <img src="https://img.shields.io/badge/Python-3.x-yellow.svg" alt="Python Version"/>
  <img src="https://img.shields.io/badge/Platform-Cross--Platform-lightgrey.svg" alt="Platform"/>
  <a href="https://github.com/roberto117343/ThresholdXpert/raw/refs/heads/main/ThresholdXpert-1.0.jar">
    <img src="https://img.shields.io/badge/Download-.jar-blue" alt="Download .jar"/>
  </a>
</p>

<p align="center">
  <a href="https://github.com/roberto117343/ThresholdXpert">📂 Official Repository (Code and Releases)</a><br>
  <a href="https://github.com/roberto117343/ThresholdXpert/raw/refs/heads/main/ThresholdXpert-1.0.jar">⬇ Download ThresholdXpert 1.0</a>
</p>

---

## Motivation

Selecting appropriate **cut-off thresholds** for diagnostic biomarkers, and even more for **combined multimarker panels**, is crucial to achieve a practical balance between **sensitivity** and **specificity**. ThresholdXpert 1.0 integrates these needs into an intuitive and reproducible interface that complements **mathematical modeling** support and allows **direct optimization** of combined thresholds.

---

## Key Features

1. **Calculate Thresholds**
   Optimizes thresholds for **variable panels** with OR/AND/mixed rules to meet target performance goals (e.g., sensitivity, specificity, overall accuracy). Allows restricting the **search space** per variable and uses **multithreading** (up to 8 threads).

2. **Evaluate CSV**
   Applies previously selected thresholds to a dataset and outputs metrics (Sensitivity, Specificity, Overall Accuracy) and the resulting binary classification for each record.

3. **Prediction Values**
   Enter values manually for a single case (e.g., one patient), and the tool reports if it is classified as **positive** or **negative** according to the current thresholds.

4. **Two-Stage Workflow Compatibility**
   The app integrates with **supporting Python scripts (S3.x)** that build empirical profiles and logistic models for **individual biomarkers**, helping select initial thresholds before combining them into the panel.

---

## Supporting Scripts (Python, S3.x)

* **S3.1 – Empirical Profile**: computes and plots empirical sensitivity/specificity.
* **S3.2 – Bulk Profile Calculation**: generates Sens/Spec series for multiple cut-offs.
* **S3.3 – Logistic Fit**: fits logistic functions to empirical profiles.
* **S3.4 – Balanced Cut-off**: finds the analytical threshold where Sens = Spec.
* **S3.5 – Target-Specific Cut-offs**: computes cut-offs for a target Sens or Spec.

**Input format**:
CSV/TXT with `;` as separator. Each line = `value;class` (`1`=positive, `0`=negative). Decimals use `.`.

---

## Requirements

* **App**: Java Runtime Environment (JRE 11 or higher).
* **Scripts (optional)**: Python 3.x, matplotlib.

---

## Installation & Usage (App)

```bash
java -jar ThresholdXpert-1.0.jar
```

1. **Input**: CSV file with variables in columns, last column = class (`0/1`).
2. **Calculation Type**: `Calculate Thresholds`, `Evaluate CSV`, or `Prediction Values`.
3. **Parameters**:

   * *Search values*: target Sens;Spec;Total (e.g., `0.7;0.7;0.7`)
   * *Maximum values*: per variable upper bounds (`;` separated)
   * *Threads*: up to 8
4. **Output**: file name and folder.

---

## Usage (Scripts)

```bash
python S3.1.py
python S3.2.py
python S3.3.py
python S3.4.py
python S3.5.py
```

* Prepare `value;class` input files.
* Scripts output empirical profiles, logistic fits, balanced and target cut-offs.

---

## Examples & Use Cases

* **Single biomarkers**: obtain empirical profiles, logistic models, and inverse-derived cut-offs for performance targets.
* **Multimarker panels**: use initial thresholds as guides, then optimize directly with ThresholdXpert 1.0.
* **Single case prediction**: classify one case with the active thresholds.

---

## Limitations

* Output quality depends on correct preprocessing and input format.
* For large panels, some thresholds may show instability; removing non-informative variables is recommended.
* Final Sens/Spec balance reflects user-defined targets and search ranges.

---

## Future Development

* Expanded support for combination rules and reporting.
* Additional export formats (tables/figures) and cross-validation support.
* More flexible performance profiles (e.g., clinical weighting).

---

## Citation

> Reinosa R. *Determination and Optimization of Diagnostic Thresholds for Multimarker Panels using a Two-Stage Approach and the ThresholdXpert 1.0 Tool.* (Manuscript/Preprint).

---

## License

Licensed under the **GNU GPL v3.0**. See [LICENSE](LICENSE).

---

## Contact

**Roberto Reinosa Fernández**
📧 [roberto117343@gmail.com](mailto:roberto117343@gmail.com)
💻 [GitHub: roberto117343](https://github.com/roberto117343/ThresholdXpert)
