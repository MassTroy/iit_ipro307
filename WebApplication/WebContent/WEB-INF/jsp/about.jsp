<!DOCTYPE html>
<html>
<head>

<jsp:include page="./include/css_includes.jsp" />
</head>
<body>
<div class=content>
	
	<h1>Passive Thermal Route Finder</h1>
	
	<h2>Thermal model</h2>
	<p>
	total heat transfer = convection + conduction + solar radiation + atmospheric radiation
	</p>
	
	<p id=completeFormula>
		M<sub>w</sub> &#8226; 
		C<sub>p,w</sub> &#8226; 
		&Delta;T<sub>w</sub> / 
		dt = 
		h<sub>fc</sub> &#8226; 
		A<sub>w</sub> &#8226; 
		(T<sub>air,out</sub> - 
		T<sub>w</sub>) + 
		k &#8226; 
		A &#8226; 
		(T - T<sub>w</sub>) / 
		&Delta;x + 
		250 &#8226; 
		0.8 &#8226; 
		sin(&Phi;) &#8226; 
		(1 - 0.75n<sup>3.4</sup>) &#8226; 
		A / 4 + 
		A &#8226; 
		&epsilon; &#8226; 
		&sigma; 
		(T<sub>sky</sub><sup>4</sup> - 
		T<sub>w</sub><sup>4</sup>)
	</p>
	
	<div>
		<h3>Conduction</h3>
		<p>
			The process by which heat is directly transmitted 
			through a substance when there is a difference of 
			temperature between two adjoining regions, 
			without movement of the material. 
		</p>
		<p>
			k = thermal conductivity (W/m&#8226;K) <br>
			A = area of the walls (m<sup>2</sup>) <br>
			T = temperature of the air outside (K) <br>
			T<sub>w</sub> = temperature of the walls (K) <br>
			&Delta;x = thickness of layer of air near the wall (m)
		</p>
		<p>
			k &#8226; 
			A &#8226; 
			(T - T<sub>w</sub>) / 
			&Delta;x
		</p>
	</div>
	
	<div>
		<h3>Convection</h3>
		<p>
			The movement caused within a fluid by the 
			tendency of hotter and therefore less dense 
			material to rise, and colder denser material to sink 
			under the influence of gravity, which consequently 
			results in transfer of heat.
		</p>
		<p>
			h<sub>fc</sub> = forced convective heat transfer coefficient (W/m2&#8226;K) <br>
			A<sub>w</sub> = area of the walls (m2) <br>
			T<sub>air,out</sub> = temperature of the air outside <br>
			T<sub>w</sub> = temperature of the walls
		</p>
		<p>
			h<sub>fc</sub> &#8226; 
			A<sub>w</sub> &#8226; 
			(T<sub>air,out</sub> - 
			T<sub>w</sub>)
		</p>
	</div>
	
	<div>
		<h3>Solar and Radiation</h3>
		<p>
			The radiant energy emitted by 
			the sun, particularly 
			electromagnetic energy.
		</p>
		<p>
			250 = solar radiation when sun directly overhead <br>
			0.8 = absorption of painted steel <br>
			&Phi; = angle of the sun (degrees) <br>
			n = sky cover percentage (0.0-1.0) <br>
			A = area of the walls (m<sup>2</sup>)
		</p>
		<p>
			250 &#8226; 
			0.8 &#8226; 
			sin(&Phi;) &#8226; 
			(1 - 0.75n<sup>3.4</sup>) &#8226; 
			A / 4
		</p>
	</div>
	
	<div>
		<h3>Atmospheric Radiation</h3>
		<p>
			The radiant energy absorbed and then 
			emitted by the Earth's surface, particularly 
			electromagnetic energy. 
		</p>
		<p>
			A = area of the walls (m2) <br>
			&epsilon; = surface emissivty (0.96) <br>
			&sigma; = Stefan-Boltzmann constant  <br>
			T<sub>sky</sub> = temperature of the sky (K) <br>
			T<sub>w</sub> = temperature of the walls (K)
		</p>
		<p>
			A &#8226; 
			&epsilon; &#8226; 
			&sigma; 
			(T<sub>sky</sub><sup>4</sup> - 
			T<sub>w</sub><sup>4</sup>)
		</p>
	</div>
	
	
</div><!-- / content -->
